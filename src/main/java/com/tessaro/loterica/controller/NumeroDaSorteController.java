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
import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.dto.NumeroDaSorteDTO;
import com.tessaro.loterica.service.NumeroDaSorteService;

@RestController
@RequestMapping("/numeros")
public class NumeroDaSorteController {
	
	@Autowired
	private NumeroDaSorteService service;
	
	@Autowired
	private ApplicationEventPublisher publisher;

//	@Secured("ROLE_ADMIN")
	@PostMapping
	public ResponseEntity<NumeroDaSorteDTO> sortearNumero (@Valid @RequestBody Email email, HttpServletResponse response) {
		NumeroDaSorteDTO numeroSalvo = service.sortear(email.getEmail());
		publisher.publishEvent(new RecursoCriadoEvent(this, response, numeroSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(numeroSalvo);
	}
}
