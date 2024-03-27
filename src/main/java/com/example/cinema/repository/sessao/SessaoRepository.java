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

    public Sessao findBy(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM sessao WHERE ID = ?", sessaoRowMapper, id);
    }

    public List<Sessao> findAll() {
        return jdbcTemplate.query("SELECT * FROM SESSAO S INNER join  FILME F on S.id_filme = F.id LEFT OUTER JOIN CINEMA.SALA S2 on S2.ID = S.ID_SALA", sessaoRowMapper);
    }

    public void save(Sessao sessao) {
        jdbcTemplate.update("INSERT INTO SESSAO (ID, ID_FILME, ID_SALA) VALUES (?,?,?)", sessao.getId(), sessao.getIdFilme(), sessao.getIdSala());
    }
}
