package com.example.cinema.service;

import com.example.cinema.controller.Dto.SessaoRecordDTOController;
import com.example.cinema.domain.Sessao;
import com.example.cinema.repository.SessaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;

    public List<Sessao> getAllSessoes() {
        return sessaoRepository.findAll();
    }


    public Object getById( UUID id) {
        Optional<Sessao> sessao = sessaoRepository.findById(id);
        return sessao.get();
    }


    public Sessao saveSessao(SessaoRecordDTOController sessaoRecordDTOController){
        var sessao = new Sessao();
        BeanUtils.copyProperties(sessaoRecordDTOController, sessao);
        return sessaoRepository.save(sessao);
    }
}
