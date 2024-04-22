package com.example.cinema.controller.sessao;

import com.example.cinema.application.sessao.dto.SessaoDTO;
import com.example.cinema.domain.Sessao;
import com.example.cinema.service.sessao.SessaoService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Listar todas as sessões")
    @GetMapping
    public ResponseEntity<List<Sessao>> getAllSessoes() {
        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.getAllSessoes());
    }

    @Operation(summary = "Buscar por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.getById(id));
    }

    @Operation(summary = "Adiciona sessão")
    @PostMapping
    public ResponseEntity<Sessao> saveSessao(@RequestBody @Valid SessaoDTO sessao){
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoService.saveSessao(sessao));
    }

    @Operation(summary = "Atualiza por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Sessao> updateSessao(@PathVariable(value = "id") String id, @RequestBody @Valid SessaoDTO sessaoDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sessaoService.updateSessao(id, sessaoDTO));
    }

    @Operation(summary = "Remove por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Sessao> removeSessao(@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(sessaoService.deleteSessao(id));
    }

}
