package br.com.controle.painel.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.controle.painel.controller.dto.DespesaDto;
import br.com.controle.painel.controller.form.AtualizacaoDespesaForm;
import br.com.controle.painel.controller.form.DespesaForm;
import br.com.controle.painel.modelo.Despesa;
import br.com.controle.painel.modelo.StatusDespesa;
import br.com.controle.painel.repository.DespesaRepository;



@RestController
@RequestMapping("/despesas")
public class DespesasController {

	@Autowired
	private DespesaRepository despesaRepository;
	
	@GetMapping
	public List<DespesaDto> lista(StatusDespesa status){
		
		if (status == null) {
			List<Despesa> despesas = despesaRepository.findAll();
			return DespesaDto.converter(despesas);
		}else {
			List<Despesa> despesas = despesaRepository.findByStatus(status);
			return DespesaDto.converter(despesas);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<DespesaDto> cadastrar(@RequestBody @Valid DespesaForm form, UriComponentsBuilder uriBuilder) {
		Despesa despesa = form.converter();
		despesaRepository.save(despesa);
		
		URI uri = uriBuilder.path("/despesas/{id}").buildAndExpand(despesa.getId()).toUri();
		return ResponseEntity.created(uri).body(new DespesaDto(despesa));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DespesaDto> detalhar(@PathVariable Long id) {
		Optional<Despesa> despesa = despesaRepository.findById(id);
		if(despesa.isPresent()) {
			return ResponseEntity.ok(new DespesaDto(despesa.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public  ResponseEntity<DespesaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoDespesaForm form){
		Optional<Despesa> optional = despesaRepository.findById(id);
		if(optional.isPresent()) {
			Despesa despesa = form.atualizar(id, despesaRepository);
			return ResponseEntity.ok(new DespesaDto(despesa));
		}
		return ResponseEntity.notFound().build();
		
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Optional<Despesa> optional = despesaRepository.findById(id);
		if(optional.isPresent()) {
			despesaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
