package com.example.api_application.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String tipo;

    @ManyToMany
    @JoinTable(
            name = "permissao_usuario",
            joinColumns = @JoinColumn(name = "permissao_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private String descricao;

}
