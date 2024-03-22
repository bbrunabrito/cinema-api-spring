package com.example.cinema.controller.Dto;

import com.example.cinema.domain.Filme;
import com.example.cinema.domain.Sala;
import jakarta.validation.constraints.NotNull;

public record SessaoRecordDTOController(@NotNull Filme filme, @NotNull Sala sala) {
}
