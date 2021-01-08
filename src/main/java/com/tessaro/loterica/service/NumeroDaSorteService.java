package com.tessaro.loterica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.NumeroDaSorte;
import com.tessaro.loterica.repository.EmailRepository;
import com.tessaro.loterica.repository.NumeroDaSorteRepository;

@Service
public class NumeroDaSorteService {

	@Autowired
	private NumeroDaSorteRepository repository;
	
	@Autowired 
	private EmailRepository repositoryEmail;
	
	public List<NumeroDaSorte> buscarNumeroSorteado(){
		return repository.findAll();
	}
	
	public NumeroDaSorte sortear (String email) {
		NumeroDaSorte sorteado = null;
		List<Email> emailEncontrado = repositoryEmail.findByEmail(email);
		if (!emailEncontrado.isEmpty()) {
			Random random = new Random();
			int numero = random.nextInt(1000000000);
			Long numeroLong = Long.valueOf(numero);
			Optional<NumeroDaSorte> conferencia = repository.findById(numeroLong);
			while(conferencia.isPresent()) {
				numero = random.nextInt(1000000000);
			}
			sorteado = new NumeroDaSorte(numeroLong, emailEncontrado.get(0));
			repository.save(sorteado);
		} else {
			throw new NoSuchElementException();
		}
		return sorteado;
	}
	
	
}
