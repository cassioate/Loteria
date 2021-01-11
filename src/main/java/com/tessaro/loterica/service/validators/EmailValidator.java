package com.tessaro.loterica.service.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tessaro.loterica.model.Email;
import com.tessaro.loterica.model.dto.PessoaDTO;
import com.tessaro.loterica.repository.EmailRepository;
import com.tessaro.loterica.service.annotations.EmailValido;

public class EmailValidator implements ConstraintValidator<EmailValido, PessoaDTO> {
	
	@Autowired 
	private EmailRepository repository;
	
	@Override
	public void initialize(EmailValido a) {
 	}

	@Override
	public boolean isValid(PessoaDTO pessoa, ConstraintValidatorContext cvc) {
		boolean isValid = Boolean.FALSE;
		List<Email> exist = null;
		exist = repository.findByEmail(pessoa.getEmail());
		
				try {
					if(pessoa.getEmail() == null ) {
						isValid = Boolean.TRUE; 
					}
					
					if (exist == null | exist.isEmpty()) {
						isValid = Boolean.TRUE; 
					} 
					
					if (pessoa.getEmail().isBlank()) {
						isValid = Boolean.TRUE; 
						}
					
				} catch (Exception e) {
					// Continua retornando false
				}

		return isValid;
	}
}