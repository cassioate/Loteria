package com.tessaro.loterica.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	@JsonIgnore
	@OneToOne(mappedBy = "email_proprietario")
	private Pessoa proprietario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "email_associado")
	private List<NumeroDaSorte> numero_associado;

	public Email (String email) {
		super();
		this.email = email;
	}
	
}
