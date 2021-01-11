package com.tessaro.loterica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Email")
@Getter @Setter
@NoArgsConstructor
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	@JsonIgnore
	@OneToOne(mappedBy = "email")
	private Pessoa proprietario;
	
	@JsonIgnore
	@OrderBy(value = "id")
	@ManyToMany
	@JoinTable(name = "EMAIL_NUMERO", 
	joinColumns = @JoinColumn(name = "EMAIL_ID"),
	inverseJoinColumns =  @JoinColumn(name = "NUMERO_ID"))
	private List<NumeroDaSorte> numero_associado = new ArrayList<>();
	
	
	public Email (String email) {
		super();
		this.email = email;
	}
	
}
