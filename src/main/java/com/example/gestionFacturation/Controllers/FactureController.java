package com.example.gestionFacturation.Controllers;

import com.example.gestionFacturation.Services.FactureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/facture")
@AllArgsConstructor
public class FactureController {

    @Autowired
    private FactureService factureService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFacture(@RequestParam("file") MultipartFile file,
                              @RequestParam("numero") Long numero,
                              @RequestParam("montant") double montant,
                              @RequestParam("date_facture") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFacture) {
        try {
            factureService.save(file, numero, montant, dateFacture);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
