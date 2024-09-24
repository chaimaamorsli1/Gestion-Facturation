package com.example.gestionFacturation.Controllers;

import com.example.gestionFacturation.Services.ActeAchatService;
import com.example.gestionFacturation.entities.ActeAchat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/acte")
@AllArgsConstructor
public class ActeAchatController {

    @Autowired
    private ActeAchatService acteAchatService;

    @PostMapping(value = "/upload" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upladActe(@RequestParam("file") MultipartFile file,
                          @RequestParam("numero") Long numero,
                          @RequestParam("montant") double montant,
                          @RequestParam("type") String type,
                          @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        try {
            acteAchatService.save(file, numero, montant, type, date);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @GetMapping( "/test" )
    public List<ActeAchat> getActeAchat(){
        return  acteAchatService.getActeAchat();
    }

}
