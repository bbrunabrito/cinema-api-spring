package com.example.cinema.application.sessao.conversor;

import com.example.cinema.application.sessao.dto.SessaoDTO;
import com.example.cinema.domain.Sessao;
import org.springframework.stereotype.Component;

public class SessaoConversor {

    public static Sessao of (SessaoDTO sessaoDTO) {
        Sessao sessao = new Sessao();
        sessao.setId(sessaoDTO.getId());
        sessao.setFilme(sessaoDTO.getFilme());
        sessao.setSala(sessaoDTO.getSala());
        return sessao;
    }
}
