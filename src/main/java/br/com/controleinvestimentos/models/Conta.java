package br.com.controleinvestimentos.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_CONTAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeCriacao;

    private BigDecimal valorTotalInvestido;

    @OneToMany(mappedBy = "conta", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Investimento>investimentos;

}
