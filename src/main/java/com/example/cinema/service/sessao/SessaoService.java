package com.example.cinema.service.sessao;

import com.example.cinema.application.sessao.conversor.SessaoConversor;
import com.example.cinema.application.sessao.dto.SessaoDTO;
import com.example.cinema.domain.Filme;
import com.example.cinema.domain.Sala;
import com.example.cinema.domain.Sessao;
import com.example.cinema.enums.SessaoMensagens;
import com.example.cinema.exceptions.ApiRequestException;
import com.example.cinema.repository.filme.FilmeRepository;
import com.example.cinema.repository.sala.SalaRepository;
import com.example.cinema.repository.sessao.SessaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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
        if(sessaoRepository.findCount() == 0)
            throw new ApiRequestException(SessaoMensagens.TABELA_SESSAO_VAZIA.getMensagem());

        List<Sessao> sessaoList = sessaoRepository.findAll();

        sessaoList.forEach(sessao -> {
            sessao.setFilme(filmeRepository.findById(sessao.getFilme().getId()));
            sessao.setSala(salaRepository.findById(sessao.getSala().getId()));
        });

        return sessaoList;
    }

    public Sessao getById( String id) {
        if (sessaoRepository.findCountById(id) == 0)
            throw new ApiRequestException(SessaoMensagens.SESSAO_NAO_ENCONTRADA.getMensagem());

        Sessao sessao = sessaoRepository.findBy(id);
        Sala sala = salaRepository.findById(sessao.getSala().getId());
        sessao.setSala(sala);
        Filme filme = filmeRepository.findById(sessao.getFilme().getId());
        sessao.setFilme(filme);
        return sessao;
    }


    public Sessao saveSessao(SessaoDTO sessaoDTO){
        SessaoConversor sessaoConversor = new SessaoConversor();
        Sessao sessao = sessaoConversor.of(sessaoDTO);

        if(filmeRepository.findCountById(sessao.getFilme().getId()) == 0)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_FILME_INVALDI.getMensagem());
        if (salaRepository.findCountById(sessao.getSala().getId()) == 0)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_SALA_INVALIDO.getMensagem());
        if (sessao.getId() == null)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_VAZIO.getMensagem());
        if (sessaoRepository.findCountById(sessao.getId()) != 0)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_INVALIDO.getMensagem());
        if (sessao.getFilme().getId() == null)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_FILME_VAZIO.getMensagem());
        if (sessao.getSala().getId() == null)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_SALA_VAZIO.getMensagem());

        sessaoRepository.save(sessao);
        return sessao;
    }

    public Sessao updateSessao(String id, SessaoDTO sessaoDTO) {
        Sessao sessao = getById(id);

        if (sessao.getId() == null)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_VAZIO.getMensagem());
        if (sessao.getFilme().getId() == null)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_FILME_VAZIO.getMensagem());
        if (sessao.getSala().getId() == null)
            throw new ApiRequestException(SessaoMensagens.ID_SESSAO_SALA_VAZIO.getMensagem());

        sessaoRepository.update(sessao);
        return sessao;
    }

    public Sessao deleteSessao(String id) {
        Sessao sessao = getById(id);
        sessaoRepository.remove(sessao);
        return sessao;
    }
}
