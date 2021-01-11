package com.tessaro.loterica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pessoa")
@Getter @Setter
@NoArgsConstructor
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "email_id")
	private Email email;

	public Pessoa(String nome, String email) {
		super();
		this.nome = nome;
		this.email = new Email(email);
	}

}