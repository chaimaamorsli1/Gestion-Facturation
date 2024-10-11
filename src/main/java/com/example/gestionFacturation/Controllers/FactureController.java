package com.example.gestionFacturation.Controllers;

import com.example.gestionFacturation.Services.FactureService;
import com.example.gestionFacturation.entities.Facture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public List<Facture> getFacture() {
        return factureService.getFacture();
    }

//    @PostMapping
//    public void addFacture(Facture facture) {
//        factureService.addFacture(facture);
//    }

    @DeleteMapping
    public void deleteFacture(@RequestParam int numero) {
        factureService.deleteFacture(numero);
    }

    @PutMapping
    public void updateFacture(@RequestParam int numero, @RequestBody Facture facture) {
        factureService.updateFacture(numero, facture);
    }

    //upload facture
    @PostMapping
    public ResponseEntity<String> uploadFacture(@RequestParam("file") MultipartFile file,@RequestBody Facture facture) {
        try {
            factureService.uploadFacture(file, facture);
             return ResponseEntity.ok("File uploaded successfully ! ");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to access" + e.getMessage());
        }


    }
}
