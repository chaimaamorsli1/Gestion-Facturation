package com.example.gestionFacturation.Controllers;

import com.example.gestionFacturation.Services.FactureService;
import com.example.gestionFacturation.entities.Facture;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "facture")
public class FactureController {
    private FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }
    @GetMapping
    public List<Facture> getFacture(){
        return factureService.getFacture();
    }
    @PostMapping
    public void addFacture(Facture facture){
         factureService.addFacture(facture);
    }
    @DeleteMapping
    public  void deleteFacture(@RequestParam int numero){
        factureService.deleteFacture(numero);
    }
    @PutMapping
    public void updateFacture(@RequestParam int numero, @RequestBody Facture facture){
        factureService.updateFacture(numero,facture);
    }
}
