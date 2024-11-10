package com.example.api_application.security;

import com.example.api_application.model.Usuario;
import com.example.api_application.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiAplicationUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    //Carrega as credenciais do usuario
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("Usuario com email:" + email + " nao encontrado"));

        List<GrantedAuthority> authorities = List.of( new SimpleGrantedAuthority(usuario.getRole()));

        return new User(usuario.getEmail(), usuario.getSenha(), authorities);
    }

}
