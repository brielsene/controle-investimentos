package br.com.controleinvestimentos.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvestimentoDto(
        @NotBlank
        BigDecimal valor,

        String descricao,

        LocalDate data


) {
}
