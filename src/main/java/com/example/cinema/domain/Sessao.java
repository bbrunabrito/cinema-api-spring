package com.example.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
public class Sessao {
    private String id;
    private String idFilme;
    private String idSala;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }
}
