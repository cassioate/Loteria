package com.tessaro.loterica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.Pessoa;
import com.tessaro.loterica.repository.EmailRepository;
import com.tessaro.loterica.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired EmailRepository repositoryEmail;
	
	public List<Pessoa> buscar(){
		return repository.findAll();
	}
	
	public Pessoa buscarPorId(Long id){
		return repository.findById(id).get();
	}
	
	public Pessoa salvar (Pessoa pessoa) {
		Email emailSalvo = repositoryEmail.save(pessoa.getEmail_proprietario());
		Pessoa pessoaSalva = repository.save(pessoa);
		emailSalvo.setProprietario(pessoaSalva);
		return pessoaSalva;
	}
}
