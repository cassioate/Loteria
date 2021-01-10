package com.tessaro.loterica.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tessaro.loterica.event.RecursoCriadoEvent;
import com.tessaro.loterica.model.dto.PessoaDTO;
import com.tessaro.loterica.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
//	@Secured("ROLE_ADMIN")
	@PostMapping
	public ResponseEntity<PessoaDTO> salvar (@Valid @RequestBody PessoaDTO pessoa, HttpServletResponse response) {
		PessoaDTO pessoaSalva = service.salvar(pessoa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
}
