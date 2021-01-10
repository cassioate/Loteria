package com.tessaro.loterica.model.dto;

import com.sun.istack.NotNull;
import com.tessaro.loterica.service.annotations.EmailValido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EmailValido
public class PessoaDTO {
	
	private Long id;

	@NotNull
	private String nome;
	
	@NotNull
	private EmailDTO email_proprietario;
	
}
