package br.com.controleinvestimentos.controllers;

import br.com.controleinvestimentos.dtos.ContaDto;
import br.com.controleinvestimentos.dtos.ContaResponseDto;
import br.com.controleinvestimentos.services.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaResponseDto>cadastrarConta(@RequestBody @Valid ContaDto contaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.cadastraConta(contaDto));
    }

    @GetMapping
    public ResponseEntity<List<ContaResponseDto>>getAllContas(){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.getAllContas());
    }
}
