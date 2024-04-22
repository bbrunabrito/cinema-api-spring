package com.example.cinema.service.filme;

import com.example.cinema.application.filme.dto.FilmeDTO;
import com.example.cinema.domain.Filme;
import com.example.cinema.enums.FilmeMensagens;
import com.example.cinema.exceptions.ApiRequestException;
import com.example.cinema.repository.filme.FilmeRepository;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> getAllFilmes() {
        if(filmeRepository.findCount() == 0)
            throw new ApiRequestException(FilmeMensagens.TABELA_FILMES_VAZIA.getMensagem());
        return filmeRepository.findyByAll();
    }



    public Filme getOneFilme(String id) {
        if(filmeRepository.findCountById(id) == 0)
            throw new ApiRequestException(FilmeMensagens.FILME_NAO_ENCONTRADO.getMensagem());
        Filme filme = filmeRepository.findById(id);
        return filme;
    }


    public Filme saveFilme(FilmeDTO filmeRecordDTOController) {
        if(filmeRecordDTOController.getNome() == null)
            throw new ApiRequestException(FilmeMensagens.NOME_FILME_VAZIO.getMensagem());
        if(filmeRecordDTOController.getId() == null)
            throw new ApiRequestException(FilmeMensagens.ID_FILME_VAZIO.getMensagem());
        if (filmeRepository.findCountById(filmeRecordDTOController.getId()) != 0)
            throw new ApiRequestException(FilmeMensagens.ID_FILME_INVALIDO.getMensagem());

        var filme = new Filme();
        BeanUtils.copyProperties(filmeRecordDTOController, filme);
        filmeRepository.save(filme);
        return filme;
    }

    public Filme updateFilme(String id, FilmeDTO filmeDTO) {
        if (filmeRepository.findCountById(id) == 0)
            throw new ApiRequestException(FilmeMensagens.FILME_NAO_ENCONTRADO.getMensagem());
        if(filmeDTO.getNome() == null)
            throw new ApiRequestException(FilmeMensagens.NOME_FILME_VAZIO.getMensagem());
        Filme filme = new Filme();
        BeanUtils.copyProperties(filmeDTO, filme);
        filmeRepository.update(filme);
        return filme;
    }

    public Filme deleteFilme(String id) {
        Filme filme = getOneFilme(id);
        filmeRepository.delete(filme);
        return filme;
    }
}
