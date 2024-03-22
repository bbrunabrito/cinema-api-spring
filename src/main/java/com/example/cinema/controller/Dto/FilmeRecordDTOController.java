package com.example.cinema.controller.Dto;

import jakarta.validation.constraints.NotBlank;

public record FilmeRecordDTOController(@NotBlank String nome, @NotBlank String descricao) {
}
