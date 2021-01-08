package com.tessaro.loterica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tessaro.loterica.model.NumeroDaSorte;
import com.tessaro.loterica.service.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailController {

	@Autowired
	private EmailService service;
	
	@GetMapping(value = "/{email}")
	public ResponseEntity<List<NumeroDaSorte>> buscarEmail(@PathVariable String email) {
		List<NumeroDaSorte> numeroEncontrado = service.buscarEmail(email);
		return ResponseEntity.ok().body(numeroEncontrado);
	}
	
}
