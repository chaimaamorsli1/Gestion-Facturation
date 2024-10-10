package com.example.gestionFacturation.Enums;

public enum Role {
    PRESTATAIRE,
    SAL,
    SBC,
    CA,
    SIGNATAIRE;;

    public boolean isAdmin() {
        return this == SAL;
    }

}
