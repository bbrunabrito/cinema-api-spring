package com.example.cinema.repository.filme;

import com.example.cinema.domain.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public class FilmeRepository {
    private final FilmeRowMapper filmeRowMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public FilmeRepository(FilmeRowMapper filmeRowMapper) {
        this.filmeRowMapper = filmeRowMapper;
    }

    public Filme findById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM filme WHERE id = ?", filmeRowMapper, id);
    }

    public List<Filme> findyByAll() {
        String sql = "SELECT * FROM filme";
        List<Filme> filme = jdbcTemplate.query(sql, filmeRowMapper);
        return filme;
    }

    public void save(Filme filme) {

            jdbcTemplate.update("INSERT INTO filme (ID, NOME, DESCRICAO) VALUES (?,?,?)", filme.getId() , filme.getNome(), filme.getDescricao());


            //jdbcTemplate.update("UPDATE filme SET (NOME, DESCRICAO) = (?,?) WHERE ID = ?", filme.getNome(), filme.getDescricao(), filme.getId());

    }

}
