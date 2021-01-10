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
		Email emailConverter = new Email();
		BeanUtils.copyProperties(pessoa.getEmail_proprietario(), emailConverter);
		BeanUtils.copyProperties(pessoa, pessoaASalvar, "email_proprietario");
		Email emailSalvo = repositoryEmail.save(emailConverter);
		Pessoa pessoaSalva = repository.save(pessoaASalvar);
		pessoaSalva.setEmail_proprietario(emailConverter);
		emailSalvo.setProprietario(pessoaSalva);

		BeanUtils.copyProperties(emailSalvo, pessoa.getEmail_proprietario());
		BeanUtils.copyProperties(pessoaSalva, pessoa, "email_proprietario");
		
		BeanUtils.copyProperties(pessoaSalva, pessoa);
		return pessoa;
	}
}
