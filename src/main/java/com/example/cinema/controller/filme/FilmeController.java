package com.example.cinema.controller.filme;

import com.example.cinema.application.filme.dto.FilmeDTO;
import com.example.cinema.domain.Filme;
import com.example.cinema.service.filme.FilmeService;
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


    @GetMapping
    public ResponseEntity<List<Filme>> getAllFilmes() {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getAllFilmes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getOneFilme(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getOneFilme(id));
    }

    @PostMapping
    public ResponseEntity<Filme> saveFilme(@RequestBody @Valid FilmeDTO filmeRecordDTOController) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.saveFilme(filmeRecordDTOController));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable(value = "id") String id, @RequestBody @Valid FilmeDTO filmeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.updateFilme(id, filmeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.deleteFilme(id));
    }
}
