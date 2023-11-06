package br.com.controleinvestimentos.dtos;

import br.com.controleinvestimentos.models.Conta;
import br.com.controleinvestimentos.models.Investimento;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ContaResponseDto(
        Long id,


        String nome,

        LocalDate dataDeCriacao,

        BigDecimal valorTotalInvestido,

        List<Investimento> investimentos
) {
    public ContaResponseDto (Conta conta){
        this(conta.getId(), conta.getNome(), conta.getDataDeCriacao(), conta.getValorTotalInvestido(), conta.getInvestimentos());
    }


}
