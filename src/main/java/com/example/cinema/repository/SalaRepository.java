package com.example.cinema.repository;

import com.example.cinema.domain.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaRepository extends JpaRepository<Sala, UUID> {
}
