package com.example.cinema.service;

import com.example.cinema.controller.Dto.SalaRecordDTOController;
import com.example.cinema.domain.Sala;
import com.example.cinema.repository.SalaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SalaService {
    @Autowired
    SalaRepository salaRepository;

    public List<Sala> getAllSalas() {
        return salaRepository.findAll();
    }


    public Object getOneSala(UUID id) {
        Optional<Sala> sala = salaRepository.findById(id);
        return sala.get();
    }


    public Sala saveSala(SalaRecordDTOController salaRecordDTOController) {
        var sala = new Sala();
        BeanUtils.copyProperties(salaRecordDTOController, sala);
        return salaRepository.save(sala);
    }
}
