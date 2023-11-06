package br.com.controleinvestimentos.controllers;

import br.com.controleinvestimentos.dtos.InvestimentoDto;
import br.com.controleinvestimentos.dtos.InvestimentoResponseDto;
import br.com.controleinvestimentos.services.InvestimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investimento")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @PostMapping
    public ResponseEntity<InvestimentoResponseDto>investir(@RequestBody @Valid InvestimentoDto dados){
        return ResponseEntity.status(HttpStatus.CREATED).body(investimentoService.criarInvestimento(dados));
    }
}
