package com.example.gestionFacturation.Enums;

import lombok.AllArgsConstructor;

public enum StatutFacture {
    Valide("validée"),
    Rejete("rejetée"),
    EnAttente("en attente");

    private final String statut;

    StatutFacture(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }

    @Override
    public String toString() {
        return statut;
    }
}
