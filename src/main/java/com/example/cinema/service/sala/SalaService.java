package com.example.cinema.service.sala;


import com.example.cinema.application.sala.dto.SalaDTO;
import com.example.cinema.domain.Sala;
import com.example.cinema.repository.sala.SalaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SalaService {
    @Autowired
    SalaRepository salaRepository;

    public List<Sala> getAllSalas() {

        return salaRepository.findAll();
    }


    public Sala getOneSala(String id) {
        Sala sala = salaRepository.findById(id);
        return sala;
    }


    public Sala saveSala(SalaDTO salaRecordDTOController) {
        var sala = new Sala();
        BeanUtils.copyProperties(salaRecordDTOController, sala);
        salaRepository.save(sala);
        return sala;
    }
}
