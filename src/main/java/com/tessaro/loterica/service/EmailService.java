package com.tessaro.loterica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.NumeroDaSorte;
import com.tessaro.loterica.repository.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository repository;
	
	public List<Email> buscar(){
		return repository.findAll();
	}
	
	public List<NumeroDaSorte> buscarEmail (String email) {
		Email emailBusca = repository.findByEmail(email).get(0);
		List<NumeroDaSorte> numero = emailBusca.getNumero_associado();
		return numero;
	}
}
