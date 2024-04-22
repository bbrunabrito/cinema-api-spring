package com.example.cinema.application.filme.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FilmeDTO {
    private String id;
    private String nome;
    private String descricao;
}
