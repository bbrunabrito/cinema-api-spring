package com.example.cinema.controller.sala;


import com.example.cinema.application.sala.dto.SalaDTO;
import com.example.cinema.domain.Sala;
import com.example.cinema.service.sala.SalaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {
    @Autowired
    SalaService salaService;

    @Operation(summary = "Lista todas as salas")
    @GetMapping
    public ResponseEntity<List<Sala>> getAllSalas() {
        return ResponseEntity.ok(salaService.getAllSalas());
    }

    @Operation(summary = "Busca sala por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSala(@PathVariable(value = "id")String id) {
        return ResponseEntity.status(HttpStatus.OK).body(salaService.getOneSala(id));
    }

    @Operation(summary = "Adiciona sala")
    @PostMapping
    public ResponseEntity<Sala> saveSala(@RequestBody @Valid SalaDTO salaRecordDTOController) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.saveSala(salaRecordDTOController));
    }

    @Operation(summary = "Atualiza sala por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable(value = "id") String id, @RequestBody @Valid SalaDTO salaDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(salaService.updateSala(id, salaDTO));
    }
    @Operation(summary = "Remove por ID")
    @DeleteMapping("{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable(value = "id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(salaService.deleteSala(id));
    }

}
