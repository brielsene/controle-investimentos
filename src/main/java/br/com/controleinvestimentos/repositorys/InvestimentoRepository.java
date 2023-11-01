package br.com.controleinvestimentos.repositorys;

import br.com.controleinvestimentos.models.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvestimentoRepository extends JpaRepository<Investimento, UUID> {
}
