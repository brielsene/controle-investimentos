package br.com.controleinvestimentos.services;

import br.com.controleinvestimentos.dtos.InvestimentoDto;
import br.com.controleinvestimentos.models.Investimento;
import br.com.controleinvestimentos.repositorys.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvestimentoService {
    @Autowired
    private InvestimentoRepository investimentoRepository;


    public InvestimentoDto criarInvestimento(InvestimentoDto investimentoDto){
        return null;
    }

}
