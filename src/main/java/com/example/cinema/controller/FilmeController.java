package com.example.cinema.controller;

import com.example.cinema.controller.Dto.FilmeRecordDTOController;
import com.example.cinema.domain.Filme;
import com.example.cinema.repository.FilmeRepository;
import com.example.cinema.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public ResponseEntity<Object> getOneFilme(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getOneFilme(id));
    }

    @PostMapping
    public ResponseEntity<Filme> saveFilme(@RequestBody @Valid FilmeRecordDTOController filmeRecordDTOController) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.saveFilme(filmeRecordDTOController));
    }
}
