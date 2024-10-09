package com.example.gestionFacturation.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private double montant;
    @JsonFormat  (pattern = "dd-MM-yyyy")
    private  LocalDate date_Facture;
    private String statut;

}
