package com.example.api_application.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Grupo {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @ManyToMany
    @JoinTable(
            name = "grupo_usuario",
            joinColumns = @JoinColumn( name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> usuarios = new HashSet<>();

    public Grupo() {}

    public Grupo(String nome) {}


}
