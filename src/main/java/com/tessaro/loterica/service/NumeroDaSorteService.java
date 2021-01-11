package com.tessaro.loterica.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.exceptionhandler.NegocioException;
import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.NumeroDaSorte;
import com.tessaro.loterica.model.dto.EmailDTO;
import com.tessaro.loterica.model.dto.NumeroDaSorteDTO;
import com.tessaro.loterica.repository.EmailRepository;
import com.tessaro.loterica.repository.NumeroDaSorteRepository;

@Service
public class NumeroDaSorteService {

	@Autowired
	private NumeroDaSorteRepository repository;
	
	@Autowired 
	private EmailRepository repositoryEmail;
	
	public NumeroDaSorteDTO sortear (String email) throws Exception {
		NumeroDaSorte sorteado = new NumeroDaSorte();
		List<Email> emailEncontrado = repositoryEmail.findByEmail(email);
		List<NumeroDaSorte> conferencia = null;
		NumeroDaSorte sorteadoSalvo = new NumeroDaSorte();
		
		if (!emailEncontrado.isEmpty()) {
			Random random = new Random();
			
			Integer contadorRandom = 999999999;
			Integer numero = random.nextInt(contadorRandom);
			conferencia = repository.findByNumero(numero);
			if(!conferencia.isEmpty()) {
			
			Set<Integer> contador = new HashSet<>();
					for (int i = 0 ; i < conferencia.size() ; i++) {	
						boolean acheiUm = false;
						for (int x = 0 ; x < conferencia.get(i).getEmail_associado().size() ; x++){
							Email em = conferencia.get(i).getEmail_associado().get(x);
							
							if(em.getEmail().equals(email)){							
								for (NumeroDaSorte k : em.getNumero_associado()) {
									if (k.getNumero() == numero) {
										acheiUm = true;
										}
									}
								if(acheiUm == true) {
									contador.add(numero);
									if (contador.size() == contadorRandom) {
										throw new NegocioException();
									}
									numero = random.nextInt(contadorRandom);
									i = 0;
									x = 0;
								}
							}	
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
		EmailDTO emailDTO = new EmailDTO();
		if(!conferencia.isEmpty()) {
			BeanUtils.copyProperties(conferencia.get(0), emailDTO);
		}
		NumeroDaSorteDTO sorteadoDTO = new NumeroDaSorteDTO();
		BeanUtils.copyProperties(sorteadoSalvo, sorteadoDTO);
		return sorteadoDTO;
	}
}

	
