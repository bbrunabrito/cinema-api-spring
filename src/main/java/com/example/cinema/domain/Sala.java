package com.example.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Sala {
    @Id
    private String id;
    private int numero;

    public Sala() {}
    public Sala(String id, int numero) {
        this.id = id;
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
