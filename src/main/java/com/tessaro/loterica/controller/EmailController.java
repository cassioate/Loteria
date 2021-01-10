package com.tessaro.loterica.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tessaro.loterica.event.RecursoCriadoEvent;
import com.tessaro.loterica.model.dto.EmailDTO;
import com.tessaro.loterica.service.EmailService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/emails")
public class EmailController {

	@Autowired
	private EmailService service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
//	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping(value = "/{email}")
	public ResponseEntity<EmailDTO> buscarEmail(@Valid @PathVariable String email, HttpServletResponse response) throws NotFoundException {
		EmailDTO numeroEncontrado = service.buscarEmail(email);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, numeroEncontrado.getId()));
		return ResponseEntity.ok().body(numeroEncontrado);
	}
	
}
