package com.example.api_application.service;

import com.example.api_application.model.Usuario;
import com.example.api_application.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario addUsuario(Usuario usuario) {
            String hashSenha = passwordEncoder.encode(usuario.getSenha());
            usuario.setSenha(hashSenha);
            return usuarioRepository.save(usuario);
    }


    public Usuario findUsuarioByEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.orElse(null);
    }
}
