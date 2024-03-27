package com.example.cinema.repository.sessao;

import com.example.cinema.domain.Filme;
import com.example.cinema.domain.Sala;
import com.example.cinema.domain.Sessao;
import com.example.cinema.repository.filme.FilmeRepository;
import com.example.cinema.repository.sala.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SessaoRowMapper implements RowMapper<Sessao> {
    @Override
    public Sessao mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sessao sessao = new Sessao();
        sessao.setId(rs.getString("id"));
        sessao.getSala().setId(rs.getString("id_sala"));
        sessao.getFilme().setId(rs.getString("id_filme"));
        return sessao;
    }
}
