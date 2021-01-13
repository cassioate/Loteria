package com.tessaro.loterica.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tessaro.loterica.event.RecursoCriadoEvent;
import com.tessaro.loterica.model.Email;
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
	
	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
	@GetMapping(value = "/{email}")
	public ResponseEntity<EmailDTO> buscarEmail(@Valid @PathVariable String email, HttpServletResponse response) throws NotFoundException {
		EmailDTO numeroEncontrado = service.buscarEmail(email);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, numeroEncontrado.getId()));
		return ResponseEntity.ok().body(numeroEncontrado);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EmailDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="3") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="email") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Email> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EmailDTO> listDto = list.map(obj -> new EmailDTO(obj.getId(), obj.getEmail(), obj.getNumero_associado(), obj.getProprietario()));  
		return ResponseEntity.ok().body(listDto);
	}
	
}
