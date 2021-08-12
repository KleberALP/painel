package br.com.controle.painel.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.controle.painel.modelo.Despesa;


public class DespesaForm {
	@NotNull @NotEmpty
	private String nome;
	@NotNull 
	private double valor;
	
	
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
	public Despesa converter() {
		return new Despesa(nome,valor);
	}


}
