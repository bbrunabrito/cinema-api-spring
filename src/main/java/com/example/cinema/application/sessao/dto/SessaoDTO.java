package com.example.cinema.application.sessao.dto;

import com.example.cinema.domain.Filme;
import com.example.cinema.domain.Sala;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SessaoDTO{
    private String id;
    private Filme idFilme;
    private Sala idSala;
}
