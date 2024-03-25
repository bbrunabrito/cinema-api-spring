package com.example.cinema.application.sessao.conversor;

import com.example.cinema.application.sessao.dto.SessaoDTO;
import com.example.cinema.domain.Sessao;

public class SessaoConversor {
    public static Sessao of (SessaoDTO sessaoDTO) {
        Sessao sessao = new Sessao();
        sessao.setId(sessaoDTO.getId());
        sessao.setIdFilme(sessaoDTO.getIdFilme());
        sessao.setIdSala(sessaoDTO.getIdSala());
        return sessao;
    }
}
