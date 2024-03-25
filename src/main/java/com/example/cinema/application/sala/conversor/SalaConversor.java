package com.example.cinema.application.sala.conversor;

import com.example.cinema.application.sala.dto.SalaDTO;
import com.example.cinema.domain.Sala;

public class SalaConversor {
    public static Sala of (SalaDTO salaDTO) {
        Sala sala = new Sala();
        sala.setId(salaDTO.getId());
        sala.setNumero(salaDTO.getNumero());

        return sala;
    }
}
