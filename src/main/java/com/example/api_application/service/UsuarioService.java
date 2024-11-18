package com.example.api_application.service;

import com.example.api_application.model.Permissao;
import com.example.api_application.model.Usuario;
import com.example.api_application.repository.PermissaoRepository;
import com.example.api_application.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final PermissaoRepository permissaoRepository;

    @Transactional
    public Usuario addUsuario(Usuario usuario) {
            String hashSenha = passwordEncoder.encode(usuario.getSenha());
            usuario.setSenha(hashSenha);

        return  usuarioRepository.save(usuario);
    }


    public Usuario findUsuarioByEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.orElse(null);
    }
}
