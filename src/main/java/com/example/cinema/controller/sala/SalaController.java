package com.example.cinema.controller.sala;


import com.example.cinema.application.sala.dto.SalaDTO;
import com.example.cinema.domain.Sala;
import com.example.cinema.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/salas")
public class SalaController {
    @Autowired
    SalaService salaService;

    @GetMapping
    public ResponseEntity<List<Sala>> getAllSalas() {
        return ResponseEntity.ok(salaService.getAllSalas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSala(@PathVariable(value = "id")String id) {
        return ResponseEntity.status(HttpStatus.OK).body(salaService.getOneSala(id));
    }

    @PostMapping
    public ResponseEntity<Sala> saveSala(@RequestBody @Valid SalaDTO salaRecordDTOController) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.saveSala(salaRecordDTOController));
    }
}
