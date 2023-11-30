package br.com.controleinvestimentos.services;

import br.com.controleinvestimentos.dtos.GanhosResponseDto;
import br.com.controleinvestimentos.dtos.InvestimentoDto;
import br.com.controleinvestimentos.dtos.InvestimentoResponseDto;
import br.com.controleinvestimentos.dtos.ValorAtualDto;
import br.com.controleinvestimentos.models.Conta;
import br.com.controleinvestimentos.models.EmailModel;
import br.com.controleinvestimentos.models.Investimento;
import br.com.controleinvestimentos.repositorys.ContaRepository;
import br.com.controleinvestimentos.repositorys.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.math.RoundingMode;

@Service
public class InvestimentoService {
    @Autowired
    private InvestimentoRepository investimentoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RestTemplate restTemplate;
    public List<InvestimentoResponseDto>obterInvestimentoss(int id){
        List<Investimento> all = investimentoRepository.findAll();
        List<Investimento>investimentosMatch = new ArrayList<>();
        for (Investimento i: all
             ) {
            if (i.getConta().getId() == id){
                investimentosMatch.add(i);
            }

        }


        return investimentosMatch.stream().map(InvestimentoResponseDto::new).toList();

    }
public List<Investimento> obterInvestimentosLocais(int id) {
    List<Investimento> all = investimentoRepository.findAll();
    List<Investimento> investimentosMatch = new ArrayList<>();
    for (Investimento i : all) {
        if (i.getConta().getId() == id) {
            investimentosMatch.add(i);
        }
    }
    System.out.println(investimentosMatch.get(0));
    return investimentosMatch;
}

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
        emailService.sendEmail(sendEmail(investimento));
        InvestimentoResponseDto investimentoResponseDto = new InvestimentoResponseDto(investimento);
        return investimentoResponseDto;
    }

    private static EmailModel sendEmail(Investimento investimento) {
        EmailModel emailModel = new EmailModel();
        emailModel.setMessageBody("O investimento, no valor de: "+ investimento.getValor()
        +", foi feito com sucesso \n" +
                        "O seu valor total de investimento é: "+ investimento.getConta().getValorTotalInvestido()
        );
        emailModel.setEmailTo(investimento.getConta().getEmail());
        emailModel.setSubject("Investimento feito com sucesso");
        return emailModel;

    }

    public GanhosResponseDto returnValueOfGain(Long id, ValorAtualDto valorAtualDto){
        Conta conta = contaRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("Conta com id: "+id+" não existe"));
        BigDecimal ganhos = (valorAtualDto.valorAtual().subtract(conta.getValorTotalInvestido()));
        BigDecimal valor1 = ganhos.multiply(BigDecimal.valueOf(100));
        BigDecimal porcentagemDosGanhos = valor1.divide(valorAtualDto.valorAtual(), 2, RoundingMode.HALF_UP);
        String descricao = "Você tem de ganho: "+ganhos+", e teve um rendimento de: "+porcentagemDosGanhos+"% de "+conta.getValorTotalInvestido();
        return new GanhosResponseDto(descricao);


    }

}
