package com.example.cinema.repository.sessao;

import com.example.cinema.domain.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SessaoRepository {
    private final SessaoRowMapper sessaoRowMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SessaoRepository(SessaoRowMapper sessaoRowMapper) {
        this.sessaoRowMapper = sessaoRowMapper;
    }

    public Integer findCount(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM SESSAO", Integer.class);
    }

    public Integer findCountById(String id) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM SESSAO WHERE id = ?", Integer.class, id);
    }

    public Sessao findBy(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM sessao WHERE ID = ?", sessaoRowMapper, id);
    }

    public List<Sessao> findAll() {
        String sql = "SELECT * FROM SESSAO";
        return jdbcTemplate.query(sql, sessaoRowMapper);
    }

    public void save(Sessao sessao) {
        try {
            jdbcTemplate.update("INSERT INTO SESSAO (ID, ID_FILME, ID_SALA) VALUES (?,?,?)", sessao.getId(), sessao.getFilme().getId(), sessao.getSala().getId());
        }
        catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(Sessao sessao) {
        jdbcTemplate.update("UPDATE SESSAO SET ID_FILME = ?, ID_SALA = ? WHERE ID = ?", sessao.getFilme().getId(), sessao.getSala().getId(), sessao.getId());
    }

    public void remove(Sessao sessao) {
        jdbcTemplate.update("DELETE FROM SESSAO WHERE ID = ?", sessao.getId());
    }
}
