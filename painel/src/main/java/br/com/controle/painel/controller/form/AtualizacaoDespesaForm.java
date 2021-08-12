package br.com.controle.painel.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.controle.painel.modelo.Despesa;
import br.com.controle.painel.modelo.StatusDespesa;
import br.com.controle.painel.repository.DespesaRepository;

public class AtualizacaoDespesaForm {
	
	
		@NotNull @NotEmpty
		private String nome;
		@NotNull 
		private double valor;
		@NotNull 
		private StatusDespesa status;
		
		
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
		public Despesa atualizar(Long id, DespesaRepository despesaRepository) {
			Despesa despesa = despesaRepository.getOne(id);
			despesa.setNome(this.nome);
			despesa.setStatus(this.status);
			despesa.setValor(this.valor);
			return despesa;
		}
		
		
}
