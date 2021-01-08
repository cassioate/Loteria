package com.tessaro.loterica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tessaro.loterica.model.Pessoa;
import com.tessaro.loterica.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping
	public ResponseEntity<List<Pessoa>> buscar (){
		List<Pessoa> pessoas = service.buscar();
		return ResponseEntity.ok().body(pessoas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPorId (@PathVariable Long id){
		Pessoa pessoa = service.buscarPorId(id);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar (@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = service.salvar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
}
