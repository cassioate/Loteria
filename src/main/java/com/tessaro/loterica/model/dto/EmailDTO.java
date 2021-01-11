package com.tessaro.loterica.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;

import com.sun.istack.NotNull;
import com.tessaro.loterica.model.NumeroDaSorte;
import com.tessaro.loterica.model.Pessoa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class EmailDTO {

	private Long id;
	
	@NotNull
	@Email
	private String email;
	
	private Pessoa proprietario;
	
	private List<NumeroDaSorte> numero_associado = new ArrayList<>();
	
	public EmailDTO (String email) {
		super();
		this.email = email;
	}

	public EmailDTO (Long id, String email, List<NumeroDaSorte> numero, Pessoa proprietario) {
		super();
		this.email = email;
		this.id = id;
		this.numero_associado = numero;
		this.proprietario = proprietario;
	}
}
