package br.com.controleinvestimentos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record InvestimentoDto(

        @NotNull
        Long idConta,
        @NotNull
        BigDecimal valor,

        String descricao


) {
}
