package com.tessaro.loterica.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.NumeroDaSorte;
import com.tessaro.loterica.model.dto.NumeroDaSorteDTO;
import com.tessaro.loterica.repository.EmailRepository;
import com.tessaro.loterica.repository.NumeroDaSorteRepository;

@Service
public class NumeroDaSorteService {

	@Autowired
	private NumeroDaSorteRepository repository;
	
	@Autowired 
	private EmailRepository repositoryEmail;
	
	public NumeroDaSorteDTO sortear (String email) {
		NumeroDaSorte sorteado = new NumeroDaSorte();
		List<Email> emailEncontrado = repositoryEmail.findByEmail(email);
		
		NumeroDaSorte sorteadoSalvo = new NumeroDaSorte();
		if (!emailEncontrado.isEmpty()) {
			Random random = new Random();
			int numero = random.nextInt(999999999);
			List<NumeroDaSorte> conferencia = repository.findByNumero(numero);
			if(!conferencia.isEmpty()) {
				for (NumeroDaSorte n : conferencia) {
					while(n.getEmail_associado() == emailEncontrado.get(0)) {
						numero = random.nextInt(999999999);
					}
				}
			}
			sorteado.setNumero(numero);
			sorteado.getEmail_associado().add(emailEncontrado.get(0));
			emailEncontrado.get(0).getNumero_associado().add(sorteado);
			sorteadoSalvo = repository.save(sorteado);
			
		} else {
			throw new NoSuchElementException();
		}

		NumeroDaSorteDTO sorteadoDTO = new NumeroDaSorteDTO();
		BeanUtils.copyProperties(sorteadoSalvo, sorteadoDTO);
		return sorteadoDTO;
		
	}
}
