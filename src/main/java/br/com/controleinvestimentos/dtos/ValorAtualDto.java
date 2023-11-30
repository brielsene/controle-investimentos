package br.com.controleinvestimentos.dtos;

import java.math.BigDecimal;

public record ValorAtualDto(
        BigDecimal valorAtual,

        String descricao
) {
}
