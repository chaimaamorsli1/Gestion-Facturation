package com.example.gestionFacturation.Services.Interfaces;

import com.example.gestionFacturation.entities.Facture;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface IFactureService {

    public void save(MultipartFile file,Long numero, double montant, Date date);

    public Resource load(String filename);

    public Facture findByNumero(Long id);

    public List<Facture> findAll();

//    public void addFacture(Facture facture);
}
