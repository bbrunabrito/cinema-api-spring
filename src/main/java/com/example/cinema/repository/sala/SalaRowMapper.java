package com.example.cinema.repository.sala;

import com.example.cinema.domain.Sala;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class SalaRowMapper implements RowMapper<Sala> {
    @Override
    public Sala mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sala sala = new Sala();
        sala.setId(rs.getString("id"));
        sala.setNumero(rs.getInt("numero"));

        return sala;
    }
}
