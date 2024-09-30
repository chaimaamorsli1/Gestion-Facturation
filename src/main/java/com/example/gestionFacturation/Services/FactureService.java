package com.example.gestionFacturation.Services;

import com.example.gestionFacturation.Repositories.FactureRepository;
import com.example.gestionFacturation.entities.Facture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {
    private FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }


    public  List<Facture> getFacture() {
        return  factureRepository.findAll();
    }

    public void addFacture(Facture facture) {
        factureRepository.save(facture);
    }
}
