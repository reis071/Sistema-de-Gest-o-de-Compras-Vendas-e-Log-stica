package com.example.api_application.repository;

import com.example.api_application.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, UUID> {
    Optional<Permissao> findByTipo(String tipo);
}
