package com.example.cinema.application.filme.conversor;

import com.example.cinema.application.filme.dto.FilmeDTO;
import com.example.cinema.domain.Filme;

public class FilmeConversor {
    public FilmeConversor() {}

    public static Filme of (FilmeDTO filmeDTO) {
        Filme filme = new Filme();
        filme.setId(filmeDTO.getId());
        filme.setNome(filmeDTO.getNome());
        filme.setDescricao(filmeDTO.getDescricao());

        return filme;
    }
}
