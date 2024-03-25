package com.example.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
public class Sessao {
    private String id;
    private Filme idFilme;
    private Sala idSala;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Filme getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Filme idFilme) {
        this.idFilme = idFilme;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }
}
