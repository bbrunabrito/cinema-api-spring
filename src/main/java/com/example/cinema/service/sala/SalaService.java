package com.example.cinema.service.sala;


import com.example.cinema.application.sala.dto.SalaDTO;
import com.example.cinema.domain.Sala;
import com.example.cinema.enums.SalaMensagens;
import com.example.cinema.exceptions.ApiRequestException;
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
        if(salaRepository.findCount() == 0)
            throw new ApiRequestException(SalaMensagens.TABELA_SALA_VAZIA.getMensagem());
        return salaRepository.findAll();
    }


    public Sala getOneSala(String id) {
        if(salaRepository.findCountById(id) == 0)
            throw new ApiRequestException(SalaMensagens.SALA_NAO_ENCONTRADA.getMensagem());

        Sala sala = salaRepository.findById(id);
        return sala;
    }


    public Sala saveSala(SalaDTO salaRecordDTOController) {
        if(salaRepository.findCountById(salaRecordDTOController.getId()) != 0)
            throw new ApiRequestException(SalaMensagens.ID_SALA_INVALIDO.getMensagem());
        if(salaRecordDTOController.getNumero() == null)
            throw new ApiRequestException(SalaMensagens.NUMERO_SALA_VAZIO.getMensagem());
        if(salaRecordDTOController.getId() == null)
            throw new ApiRequestException(SalaMensagens.ID_SALA_VAZIO.getMensagem());

        var sala = new Sala();
        BeanUtils.copyProperties(salaRecordDTOController, sala);
        salaRepository.save(sala);
        return sala;
    }

    public Sala updateSala(String id, SalaDTO salaDTO) {
        Sala sala = getOneSala(id);

        if (salaDTO.getNumero() == null)
            throw new ApiRequestException(SalaMensagens.NUMERO_SALA_VAZIO.getMensagem());
        if(salaDTO.getId() == null)
            throw new ApiRequestException(SalaMensagens.ID_SALA_VAZIO.getMensagem());

        BeanUtils.copyProperties(salaDTO, sala);
        salaRepository.update(sala);
        return sala;
    }

    public Sala deleteSala(String id) {
        Sala sala = getOneSala(id);
        salaRepository.delete(sala);
        return sala;
    }
}
