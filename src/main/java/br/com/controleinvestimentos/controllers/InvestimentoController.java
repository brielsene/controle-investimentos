package br.com.controleinvestimentos.controllers;

import br.com.controleinvestimentos.dtos.GanhosResponseDto;
import br.com.controleinvestimentos.dtos.InvestimentoDto;
import br.com.controleinvestimentos.dtos.InvestimentoResponseDto;
import br.com.controleinvestimentos.dtos.ValorAtualDto;
import br.com.controleinvestimentos.models.Investimento;
import br.com.controleinvestimentos.services.InvestimentoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @PostMapping
    public ResponseEntity<InvestimentoResponseDto>investir(@RequestBody @Valid InvestimentoDto dados){
        return ResponseEntity.status(HttpStatus.CREATED).body(investimentoService.criarInvestimento(dados));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GanhosResponseDto>returnGains(@PathVariable("id")Long id, @RequestBody ValorAtualDto valorAtual){
        return ResponseEntity.status(HttpStatus.OK).body(investimentoService.returnValueOfGain(id, valorAtual));
    }

}
