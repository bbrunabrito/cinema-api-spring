package com.example.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
public class Sala {
    private String id;
    private int numero;
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
