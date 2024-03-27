package com.example.cinema.domain;

import lombok.Data;

@Data
public class Sessao {
    private String id;
    private Filme filme = new Filme();
    private Sala sala = new Sala();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
