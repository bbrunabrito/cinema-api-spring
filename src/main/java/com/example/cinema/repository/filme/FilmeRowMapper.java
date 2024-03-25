package com.example.cinema.repository.filme;

import com.example.cinema.domain.Filme;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class FilmeRowMapper implements RowMapper<Filme> {
    @Override
    public Filme mapRow(ResultSet rs, int rowNum) throws SQLException {
        Filme filme = new Filme();
        filme.setId(rs.getString("id"));
        filme.setNome(rs.getString("nome"));
        filme.setDescricao(rs.getString("descricao"));

        return filme;
    }

}
