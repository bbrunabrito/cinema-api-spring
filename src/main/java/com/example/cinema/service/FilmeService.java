package com.example.cinema.service;

import com.example.cinema.application.filme.dto.FilmeDTO;
import com.example.cinema.domain.Filme;
import com.example.cinema.repository.filme.FilmeRepository;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;
    public List<Filme> getAllFilmes() {
        return filmeRepository.findyByAll();
    }

    public Object getOneFilme(String id) {
        Filme filme = filmeRepository.findById(id);
        return filme;
    }


    public Filme saveFilme(FilmeDTO filmeRecordDTOController) {
        var filme = new Filme();
        BeanUtils.copyProperties(filmeRecordDTOController, filme);
        filmeRepository.save(filme);
        return filme;
    }
}
