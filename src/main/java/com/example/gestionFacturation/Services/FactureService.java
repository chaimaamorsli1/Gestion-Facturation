package com.example.gestionFacturation.Services;

import com.example.gestionFacturation.Repositories.FactureRepository;
import com.example.gestionFacturation.entities.Facture;
import jakarta.persistence.EntityNotFoundException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class FactureService {
    private FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }


    public  List<Facture> getFacture() {
        return  factureRepository.findAll();
    }

//    public void addFacture(Facture facture) {
//        factureRepository.save(facture);
//    }

    public void deleteFacture(int id) {
        factureRepository.deleteById(id);
    }

    private final Path root = Paths.get("Uploads/Factures");  // Changed to Paths.get for consistency


    public void updateFacture(int numero, Facture facture) {
       Facture f = factureRepository.findById(numero).orElseThrow(()->new EntityNotFoundException("not found"));
       //f.setNumero(numero);
       f.setMontant(facture.getMontant());
       f.setDate_Facture(facture.getDate_Facture());
       f.setStatut(facture.getStatut());
       //factureRepository.save(f);
        try {
            factureRepository.save(f);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour de la facture : " + e.getMessage());
        }
    }


//    public void uploadFacture(MultipartFile file) throws Exception {
//        try{
//
//            if(file.isEmpty()){
//                throw new IllegalStateException("file must be empty");
//            }
//
//            String fileName = Objects.requireNonNull(file.getOriginalFilename(), "File name must not be null");
//            Path filePath = root.resolve(fileName);
//            // Copy the file to the target location
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // Create and save Facture entity
//            Facture facture = new Facture();
//            facture.setFile_path(filePath.toString());
//
//            // Save to the repository
//            factureRepository.save(facture);
//
//        }
//        catch(IOException e){
//            throw new RuntimeException("");
//        }
//        catch (Exception e){
//            throw  new RuntimeException("");
//        }
//        }
//


    public void uploadFacture(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File must not be empty");
        }

        String fileName = Objects.requireNonNull(file.getOriginalFilename(), "File name must not be null");
        Path filePath = root.resolve(fileName);

        try {
            // Ensure the directory exists
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }

            // Copy the file to the target location
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Create and save Facture entity
            Facture facture = new Facture();
            facture.setFile_path(filePath.toString());

            // Save to the repository
            factureRepository.save(facture);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred: " + e.getMessage(), e);
        }
    }

}

