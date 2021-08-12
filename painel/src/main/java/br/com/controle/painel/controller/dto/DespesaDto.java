package br.com.controle.painel.controller.dto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.controle.painel.modelo.Despesa;
import br.com.controle.painel.modelo.StatusDespesa;

public class DespesaDto {
	
	private Long id;
	private String nome;
	private double valor;
	private StatusDespesa status;
	private LocalDateTime dataCriacao;
	
	public DespesaDto(Despesa despesa) {
		this.id = despesa.getId();
		this.nome = despesa.getNome();
		this.valor = despesa.getValor();
		this.status = despesa.getStatus();
		this.dataCriacao = despesa.getDataCriacao();
	}
	
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}
	public StatusDespesa getStatus() {
		return status;
	}
	public static List<DespesaDto> converter(List<Despesa> despesa) {
		return despesa.stream().map(DespesaDto::new).collect(Collectors.toList());
	}

	
}
