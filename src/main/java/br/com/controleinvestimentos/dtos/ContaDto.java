package br.com.controleinvestimentos.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ContaDto(

        Long id,

        @NotBlank
        String nome,

        @Email
        String email,

        BigDecimal valorTotalInvestido
) {
}
