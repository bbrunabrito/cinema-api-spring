package com.example.cinema.service.sessao;

import com.example.cinema.application.sessao.dto.SessaoDTO;
import com.example.cinema.domain.Filme;
import com.example.cinema.domain.Sala;
import com.example.cinema.domain.Sessao;
import com.example.cinema.repository.filme.FilmeRepository;
import com.example.cinema.repository.sala.SalaRepository;
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

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private SalaRepository salaRepository;

    public List<Sessao> getAllSessoes() {
        return sessaoRepository.findAll();
    }


    public Sessao getById( String id) {
        Sessao sessao = sessaoRepository.findBy(id);
        Sala sala = salaRepository.findById(sessao.getSala().getId());
        sessao.setSala(sala);
        Filme filme = filmeRepository.findById(sessao.getFilme().getId());
        sessao.setFilme(filme);
        return sessao;
    }


    public Sessao saveSessao(SessaoDTO sessaoRecordDTOController){
        var sessao = new Sessao();
        BeanUtils.copyProperties(sessaoRecordDTOController, sessao);
        sessaoRepository.save(sessao);
        return sessao;
    }
}
