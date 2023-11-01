package br.com.controleinvestimentos.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_INVESTIMENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private BigDecimal valor;
    private String descricao;
    private LocalDate data;
    @ManyToOne()
    @JoinColumn(name = "conta_id")
    @JsonBackReference
    private Conta conta;
}
