package com.example.api_application.service;

import com.example.api_application.model.Permissao;
import com.example.api_application.repository.PermissaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;


    @Transactional
    public Permissao addPermissao(Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    public Permissao getPermissao(String tipo) {
        Optional<Permissao> permissao = permissaoRepository.findByTipo(tipo);

        return permissao.orElse(null);
    }
}
