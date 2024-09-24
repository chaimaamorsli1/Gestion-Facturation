package com.example.gestionFacturation.Services;

import com.example.gestionFacturation.Repositories.ActeAchatRepository;
import com.example.gestionFacturation.Services.Interfaces.IActeAchatService;
import com.example.gestionFacturation.entities.ActeAchat;
import com.example.gestionFacturation.entities.Facture;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ActeAchatService implements IActeAchatService {

    private final Path root = Path.of("uploads");

    private ActeAchatRepository acteAchatRepo;

    @Override
    public void save(MultipartFile file, long numero, double montant,String type, Date date) {
        try {
            Path filepath = root.resolve(Objects.requireNonNull(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);

            ActeAchat acte = new ActeAchat();
            acte.setNumero(numero);
            acte.setMontant(montant);
            acte.setType(type);
            acte.setFile_name(file.getOriginalFilename());
            acte.setFile_path(filepath.toString());

            acteAchatRepo.save(acte);
        }
        catch (FileAlreadyExistsException e) {
            throw new RuntimeException("File already exists: " + e.getFile(), e);
        } catch (IOException e) {
            throw new RuntimeException("Error saving file: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }


    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public ActeAchat findByNumero(Long id) {
        return acteAchatRepo.findActeByNumero(id).orElseThrow(()->new RuntimeException("Acte not found"));
    }


    @Override
    public List<ActeAchat> findAll() {
        return acteAchatRepo.findAll();
    }
}
