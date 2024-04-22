package com.example.cinema.controller.filme;

import com.example.cinema.application.filme.dto.FilmeDTO;
import com.example.cinema.domain.Filme;
import com.example.cinema.exceptions.ApiRequestException;
import com.example.cinema.service.filme.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;


    @Operation(summary = "Lista todos os filmes")
    @GetMapping
    public ResponseEntity<List<Filme>> getAllFilmes() {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getAllFilmes());
    }

    @Operation(summary = "Busca filme por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Filme> getOneFilme(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getOneFilme(id));
    }

    @Operation(summary = "Adiciona filme")
    @PostMapping
    public ResponseEntity<Filme> saveFilme(@RequestBody @Valid FilmeDTO filmeRecordDTOController) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.saveFilme(filmeRecordDTOController));
    }

    @Operation(summary = "Busca filme por ID e atualiza o filme encontrado")
    @PutMapping("/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable(value = "id") String id, @RequestBody @Valid FilmeDTO filmeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.updateFilme(id, filmeDTO));
    }

    @Operation(summary = "Remove filme por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.deleteFilme(id));
    }
}
