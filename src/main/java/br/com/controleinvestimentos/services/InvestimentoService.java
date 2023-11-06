package br.com.controleinvestimentos.services;

import br.com.controleinvestimentos.dtos.InvestimentoDto;
import br.com.controleinvestimentos.dtos.InvestimentoResponseDto;
import br.com.controleinvestimentos.models.Conta;
import br.com.controleinvestimentos.models.Investimento;
import br.com.controleinvestimentos.repositorys.ContaRepository;
import br.com.controleinvestimentos.repositorys.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class InvestimentoService {
    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private ContaRepository contaRepository;


    public InvestimentoResponseDto criarInvestimento(InvestimentoDto investimentoDto){
        LocalDate now = LocalDate.now();
        Conta conta = contaRepository.findById(investimentoDto.idConta()).orElseThrow(()
                -> new NoSuchElementException("Conta com este id não encontrada"));
        Investimento investimento = new Investimento(null, investimentoDto.valor(),
                investimentoDto.descricao(), now, conta);
        if(conta.getValorTotalInvestido().equals(BigDecimal.ZERO)){
            conta.setValorTotalInvestido(investimentoDto.valor());
        }else{
            conta.setValorTotalInvestido(conta.getValorTotalInvestido().add(investimentoDto.valor()));
        }
        investimentoRepository.save(investimento);
        InvestimentoResponseDto investimentoResponseDto = new InvestimentoResponseDto(investimento);
        return investimentoResponseDto;
    }

}
