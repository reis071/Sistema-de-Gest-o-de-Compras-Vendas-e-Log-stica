package com.example.api_application.controller;

import com.example.api_application.model.Usuario;
import com.example.api_application.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario/")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("cadastrar")
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.addUsuario(usuario);
    }

    @GetMapping("email")
    public Usuario findByUsuarioEmail(@RequestParam String email) {
        return usuarioService.findUsuarioByEmail(email);
    }

}
