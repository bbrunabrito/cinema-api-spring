package com.example.cinema.repository;

import com.example.cinema.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessaoRepository extends JpaRepository<Sessao, UUID>{

}
