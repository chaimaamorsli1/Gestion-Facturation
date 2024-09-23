package com.example.gestionFacturation.Repositories;

import com.example.gestionFacturation.entities.ActeAchat;
import com.example.gestionFacturation.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActeAchatRepository extends JpaRepository<ActeAchat, Long> {
    Optional<ActeAchat> findActeByNumero(Long numero);
}
