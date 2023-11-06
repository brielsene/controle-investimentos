package br.com.controleinvestimentos.dtos;

import br.com.controleinvestimentos.models.Conta;
import br.com.controleinvestimentos.models.Investimento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record InvestimentoResponseDto(

        UUID uuid,
        BigDecimal valor,
        String descricao,
        LocalDate data,

        Conta conta
) {
    public InvestimentoResponseDto(Investimento investimento){
        this(investimento.getUuid(), investimento.getValor(), investimento.getDescricao(), investimento.getData(), investimento.getConta());
    }
}
