package com.example.cinema.repository.sala;

import com.example.cinema.domain.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalaRepository {
    private final SalaRowMapper salaRowMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalaRepository(SalaRowMapper salaRowMapper) {
        this.salaRowMapper = salaRowMapper;
    }

    public Sala findById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM sala WHERE id = ?", salaRowMapper, id);
    }

    public List<Sala> findAll() {
        return jdbcTemplate.query("SELECT * FROM sala", salaRowMapper);
    }

    public void save(Sala sala) {
        jdbcTemplate.update("INSERT INTO sala (ID, NUMERO) VALUES (?,?)", sala.getId(), sala.getNumero());
    }
}
