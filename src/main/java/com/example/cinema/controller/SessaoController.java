package com.example.cinema.controller;

import com.example.cinema.controller.Dto.SessaoRecordDTOController;
import com.example.cinema.domain.Sessao;
import com.example.cinema.repository.SessaoRepository;
import com.example.cinema.service.SessaoService;
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
@RequestMapping("/sessoes")
public class SessaoController {
    @Autowired
    SessaoService sessaoService;

    @GetMapping
    public ResponseEntity<List<Sessao>> getAllSessoes() {
        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.getAllSessoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Sessao> saveSessao(@RequestBody @Valid SessaoRecordDTOController sessaoRecordDTOController){
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoService.saveSessao(sessaoRecordDTOController));
    }

}
