package com.example.cinema.application.sessao.dto;

import com.example.cinema.domain.Filme;
import com.example.cinema.domain.Sala;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SessaoDTO{
    private String id;
    private Filme filme;
    private Sala sala;
}
