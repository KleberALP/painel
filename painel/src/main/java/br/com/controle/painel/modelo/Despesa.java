package br.com.controle.painel.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Despesa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double valor;
	@Enumerated(EnumType.STRING)
	private StatusDespesa status = StatusDespesa.PENDENTE;
	private LocalDateTime dataCriacao = LocalDateTime.now();

	
	public Despesa() {
		
	}
	
	public Despesa(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public StatusDespesa getStatus() {
		return status;
	}
	public void setStatus(StatusDespesa status) {
		this.status = status;
	}
	
	
	
}
