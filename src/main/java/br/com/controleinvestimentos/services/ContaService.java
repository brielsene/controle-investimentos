package br.com.controleinvestimentos.services;

import br.com.controleinvestimentos.dtos.ContaDto;
import br.com.controleinvestimentos.dtos.ContaResponseDto;
import br.com.controleinvestimentos.models.Conta;
import br.com.controleinvestimentos.repositorys.ContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public ContaResponseDto cadastraConta(ContaDto contaDto){
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Conta conta = new Conta();
        conta.setNome(contaDto.nome());
        LocalDate now = LocalDate.now();
        now.format(sdf);
        conta.setDataDeCriacao(now);
        contaDto.dataDeCriacao();
        conta.setValorTotalInvestido(BigDecimal.ZERO);
        contaRepository.save(conta);
        ContaResponseDto contaResponseDto = new ContaResponseDto(conta);
        return contaResponseDto;

    }

    public List<ContaResponseDto>getAllContas(){
        List<Conta> all = contaRepository.findAll();
        return all.stream().map(ContaResponseDto::new).toList();
    }
}
