package com.example.gestionFacturation.Repositories;

import com.example.gestionFacturation.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    Optional<Facture> findFactureByNumero(Long numero);
}
