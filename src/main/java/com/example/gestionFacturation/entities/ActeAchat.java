package com.example.gestionFacturation.entities;

import com.example.gestionFacturation.Enums.StatutFacture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Long numero;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private double montant;
    @Column(nullable = false)

    private String file_name;
    //    private FileType file_type;
    private String file_path;

    @OneToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

}
