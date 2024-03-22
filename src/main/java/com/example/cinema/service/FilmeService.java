package com.example.cinema.service;

import com.example.cinema.controller.Dto.FilmeRecordDTOController;
import com.example.cinema.domain.Filme;
import com.example.cinema.repository.FilmeRepository;
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
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;
    public List<Filme> getAllFilmes() {
        return filmeRepository.findAll();
    }

    public Object getOneFilme(UUID id) {
        Optional<Filme> filme = filmeRepository.findById(id);

        return filme.get();
    }


    public Filme saveFilme(FilmeRecordDTOController filmeRecordDTOController) {
        var filme = new Filme();
        BeanUtils.copyProperties(filmeRecordDTOController, filme);
        return filmeRepository.save(filme);
    }
}
