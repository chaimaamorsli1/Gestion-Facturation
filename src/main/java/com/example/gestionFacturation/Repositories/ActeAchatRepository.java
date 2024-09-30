package com.example.gestionFacturation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActeAchatRepository extends JpaRepository<ActeAchat, Long> {
    Optional<ActeAchat> findActeByNumero(Long numero);
}
