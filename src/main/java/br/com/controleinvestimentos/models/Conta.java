package br.com.controleinvestimentos.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_CONTAS")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String nome;
    private LocalDate dataDeCriacao;

    private BigDecimal valorTotalInvestido;

    @OneToMany(mappedBy = "conta", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Investimento>investimentos;

}
