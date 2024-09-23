package com.example.gestionFacturation.Services.Interfaces;

import com.example.gestionFacturation.entities.ActeAchat;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


public interface IActeAchatService {
    public void save(MultipartFile file, long numero,double montant, String type, Date date);

    public Resource load(String filename);

    public ActeAchat findByNumero(Long id);

    public List<ActeAchat> findAll();
}
