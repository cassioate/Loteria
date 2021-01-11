package com.tessaro.loterica.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.Pessoa;
import com.tessaro.loterica.model.dto.PessoaDTO;
import com.tessaro.loterica.repository.EmailRepository;
import com.tessaro.loterica.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired 
	private EmailRepository repositoryEmail;

	public PessoaDTO salvar (PessoaDTO pessoa) {
		Pessoa pessoaASalvar = new Pessoa();
		Email email = repositoryEmail.save(new Email(pessoa.getEmail()));
		
		BeanUtils.copyProperties(pessoa, pessoaASalvar, "email");
		pessoaASalvar.setEmail(email);
		
		Pessoa pessoaSalva = repository.save(pessoaASalvar);
		email.setProprietario(pessoaASalvar);

		BeanUtils.copyProperties(pessoaSalva, pessoa, "email");
		pessoa.setEmail(email.getEmail());
		
		return pessoa;
	}
}
