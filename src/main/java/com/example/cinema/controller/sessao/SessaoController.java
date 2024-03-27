package com.example.cinema.controller.sessao;


import com.example.cinema.application.sessao.dto.SessaoDTO;
import com.example.cinema.domain.Sessao;
import com.example.cinema.service.sessao.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Object> getById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Sessao> saveSessao(@RequestBody @Valid SessaoDTO sessao){
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoService.saveSessao(sessao));
    }

}
