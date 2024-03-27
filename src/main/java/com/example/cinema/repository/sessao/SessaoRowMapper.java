package com.example.cinema.repository.sessao;

import com.example.cinema.domain.Filme;
import com.example.cinema.domain.Sala;
import com.example.cinema.domain.Sessao;
import jakarta.annotation.security.RolesAllowed;
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
        sessao.setIdSala(rs.getString("id_sala"));
        sessao.setIdFilme(rs.getString("id_filme"));
        return sessao;
    }
}
