package com.example.api_application.service;

import com.example.api_application.model.Grupo;
import com.example.api_application.repository.GrupoRepository;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public Grupo addGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }
}
