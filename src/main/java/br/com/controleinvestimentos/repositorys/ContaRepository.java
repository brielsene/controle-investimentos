package br.com.controleinvestimentos.repositorys;

import br.com.controleinvestimentos.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
}
