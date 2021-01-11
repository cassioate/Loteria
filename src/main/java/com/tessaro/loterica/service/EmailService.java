package com.tessaro.loterica.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.dto.EmailDTO;
import com.tessaro.loterica.repository.EmailRepository;

import javassist.NotFoundException;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository repository;
	
	public List<Email> buscar(){
		return repository.findAll();
	}
	
	public EmailDTO buscarEmail (String email) throws NotFoundException{
		List<Email> emailEncontrado = repository.findByEmail(email);
		Email emailUnico = new Email();	
		if (!emailEncontrado.isEmpty()) {
			emailUnico = emailEncontrado.get(0);
		} else {
			throw new NoSuchElementException();
		}
		EmailDTO emailDTO = new EmailDTO();
		BeanUtils.copyProperties(emailUnico, emailDTO);
		return emailDTO;
	}
	
	public Page<Email> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
}