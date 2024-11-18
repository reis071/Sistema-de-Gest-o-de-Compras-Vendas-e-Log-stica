package com.example.api_application.controller;

import com.example.api_application.model.Permissao;
import com.example.api_application.model.Usuario;
import com.example.api_application.service.PermissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("permissao/")
@RequiredArgsConstructor
public class PermissaoController {
    private final PermissaoService permissaoService;

    @PostMapping("cadastrar")
    public Permissao cadastrarPermissao(@RequestBody Permissao permissao) {
        return permissaoService.addPermissao(permissao);
    }

    @GetMapping("tipo")
    public Permissao getPermissao(@RequestParam String tipo) {
        return permissaoService.getPermissao(tipo);
    }

    @PostMapping("usuario")
    public void addPermissaoUsuario(@RequestParam String tipo,@RequestParam String email) {
        permissaoService.addPermissaoUsuario(tipo, email);
    }

}
