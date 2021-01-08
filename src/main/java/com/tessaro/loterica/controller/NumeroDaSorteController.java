package com.tessaro.loterica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tessaro.loterica.model.NumeroDaSorte;
import com.tessaro.loterica.service.NumeroDaSorteService;

@RestController
@RequestMapping("/numeros")
public class NumeroDaSorteController {
	
	@Autowired
	private NumeroDaSorteService service;
	
	@PostMapping
	public ResponseEntity<NumeroDaSorte> sortearNumero (@RequestBody String email) {
		NumeroDaSorte numeroSalvo = service.sortear(email);
		return ResponseEntity.status(HttpStatus.CREATED).body(numeroSalvo);
	}

}
