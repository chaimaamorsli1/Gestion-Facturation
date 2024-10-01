package com.example.gestionFacturation.Services;

import com.example.gestionFacturation.Repositories.FactureRepository;
import com.example.gestionFacturation.entities.Facture;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public void deleteFacture(int id) {
        factureRepository.deleteById(id);
    }

    public void updateFacture(int numero, Facture facture) {
       Facture f = factureRepository.findById(numero).orElseThrow(()->new EntityNotFoundException("not found"));
       f.setNumero(numero);
       f.setMontant(facture.getMontant());
       f.setDate_Facture(facture.getDate_Facture());
       f.setStatut(facture.getStatut());
       factureRepository.save(f);
    }


}
