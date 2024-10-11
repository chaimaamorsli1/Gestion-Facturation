package com.example.gestionFacturation.Services;

import com.example.gestionFacturation.Repositories.PVRepository;
import com.example.gestionFacturation.entities.PV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PVService {




        @Autowired
        private PVRepository pvRepository;

        public List<PV> getAllPV() {
            return pvRepository.findAll();
        }
        public PV savePV(PV pv) {
            return pvRepository.save(pv);
        }

        public Optional<PV> findById(Long id) {
            return Optional.empty();
        }
    }


