package br.com.controle.painel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controle.painel.modelo.Despesa;
import br.com.controle.painel.modelo.StatusDespesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

	List<Despesa> findByStatus(StatusDespesa status);
	
}
