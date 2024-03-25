package com.example.cinema.service;

import com.example.cinema.application.sessao.dto.SessaoDTO;
import com.example.cinema.domain.Sessao;
import com.example.cinema.repository.sessao.SessaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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


    public Sessao getById( String id) {
        Sessao sessao = sessaoRepository.findBy(id);
        return sessao;
    }


    public Sessao saveSessao(SessaoDTO sessaoRecordDTOController){
        var sessao = new Sessao();
        BeanUtils.copyProperties(sessaoRecordDTOController, sessao);
        sessaoRepository.save(sessao);
        return sessao;
    }
}
