package com.example.gestionFacturation.Services;

import com.example.gestionFacturation.Repositories.FactureRepository;
import com.example.gestionFacturation.Services.Interfaces.IFactureService;
import com.example.gestionFacturation.entities.Facture;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FactureService implements IFactureService {

    private final Path root = Paths.get("Uploads/Factures");  // Changed to Paths.get for consistency
    private final FactureRepository factureRepo;

    // Constructor-based dependency injection
    public FactureService(FactureRepository factureRepo) {
        this.factureRepo = factureRepo;
        init();  // Initialize the directory on service startup
    }

    // Ensure directory exists
    private void init() {
        try {
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!", e);
        }
    }

    @Override
    public void save(MultipartFile file, Long numero, double montant, Date date) {
        try {
            // Ensure that the file name is not null and generate the file path
            String fileName = Objects.requireNonNull(file.getOriginalFilename(), "File name must not be null");
            Path filepath = root.resolve(fileName);

            // Copy the file to the target location
            Files.copy(file.getInputStream(), filepath, StandardCopyOption.REPLACE_EXISTING);

            // Create and save Facture entity
            Facture facture = new Facture();
            facture.setNumero(numero);
            facture.setMontant_total(montant);
            facture.setDate_facture(date);
            facture.setFile_name(fileName);
            facture.setFile_path(filepath.toString());

            // Save to the repository
            factureRepo.save(facture);

        } catch (FileAlreadyExistsException e) {
            throw new RuntimeException("File already exists: " + file.getOriginalFilename(), e);
        } catch (IOException e) {
            throw new RuntimeException("Error saving file: " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            // Load the file as a resource
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error loading file: " + filename, e);
        }
    }

    @Override
    public Facture findByNumero(Long numero) {
        return factureRepo.findFactureByNumero(numero).orElseThrow(() -> new RuntimeException("Facture not found"));
    }

    @Override
    public List<Facture> findAll() {
        return factureRepo.findAll();
    }

    public List<Facture> getFacture() {
        return factureRepo.findAll();
    }
}
