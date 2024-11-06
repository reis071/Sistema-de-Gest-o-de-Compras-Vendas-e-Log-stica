package com.example.api_application.controller;

import com.example.api_application.model.Grupo;
import com.example.api_application.service.GrupoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("grupo/")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
            this.grupoService = grupoService;
    }

    @PostMapping("cadastrar")
    public Grupo cadastrarGrupo( @RequestBody Grupo grupo) {
        return grupoService.addGrupo(grupo);
    }


}
