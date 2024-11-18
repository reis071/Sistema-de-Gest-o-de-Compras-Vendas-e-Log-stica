package com.example.api_application.service;

import com.example.api_application.model.Permissao;
import com.example.api_application.model.Usuario;
import com.example.api_application.repository.PermissaoRepository;
import com.example.api_application.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Permissao addPermissao(Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    @Transactional
    public void addPermissaoUsuario(String tipo, String emailUsuario) {
        Optional<Usuario> usuarioP = usuarioRepository.findByEmail(emailUsuario);
        Optional<Permissao> permissaoP = permissaoRepository.findByTipo(tipo);

        if (usuarioP.isPresent() && permissaoP.isPresent()) {
            Usuario usuario = usuarioP.get();
            Permissao permissao = permissaoP.get();
            usuario.getPermissoes().add(permissao);
            usuarioRepository.save(usuario);
        }

    }

    public Permissao getPermissao(String tipo) {
        Optional<Permissao> permissao = permissaoRepository.findByTipo(tipo);

        return permissao.orElse(null);
    }
}
