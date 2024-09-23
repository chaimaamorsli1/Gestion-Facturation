package com.example.gestionFacturation.entities;

import com.example.gestionFacturation.Enums.StatutFacture;
import com.example.gestionFacturation.entities.Users.Prestataire;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private long numero;
    @Column(nullable = false)
    private double montant_total;
    @Column(nullable = false)
    private Date date_facture;
    @Column(nullable = false)
    private StatutFacture statut_facture = StatutFacture.EnAttente;

    private String file_name;
//  private FileType file_type;
    private String file_path;

    @ManyToOne
    @JoinColumn(name = "prestataire_id")
    private Prestataire prestataire;

    @OneToOne(mappedBy = "facture",cascade = CascadeType.ALL)
    private ActeAchat acteAchat;
}
