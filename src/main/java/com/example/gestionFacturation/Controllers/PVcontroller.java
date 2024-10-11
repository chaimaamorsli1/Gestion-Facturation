package com.example.gestionFacturation.Controllers;
import com.example.gestionFacturation.Services.PVService;
import com.example.gestionFacturation.entities.PV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Medicine")
public class PVcontroller {
    @Autowired
    private PVService pvService;

    @PostMapping
    public ResponseEntity<PV> createPV(@RequestBody PV pv) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PV> getPVById(@PathVariable Long id) {
        Optional<PV> optionalPV = pvService.findById(id);
        return optionalPV.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}


