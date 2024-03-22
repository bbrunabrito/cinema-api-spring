package com.example.cinema.repository;

import com.example.cinema.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {
}
