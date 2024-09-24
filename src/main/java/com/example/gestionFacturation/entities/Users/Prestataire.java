package com.example.gestionFacturation.entities.Users;

import com.example.gestionFacturation.entities.Facture;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("PRESTATAIRE")
public class Prestataire extends User {

    @OneToMany(mappedBy = "prestataire",cascade = CascadeType.ALL)
    private List<Facture> factures;
}
