package com.example.cinema.domain;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Sessao {
    @Id
    private String id;
    private Filme filme = new Filme();
    private Sala sala = new Sala();

    public Sessao(){}
    public Sessao(String id, Filme filme, Sala sala) {
        this.id = id;
        this.filme = filme;
        this.sala = sala;
    }

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
