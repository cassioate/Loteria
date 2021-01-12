package com.tessaro.loterica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Numero_da_sorte")
@Getter @Setter
@NoArgsConstructor
public class NumeroDaSorte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer numero;
	
	@JsonIgnore
	@NotNull
	@ManyToMany(mappedBy = "numero_associado", cascade=CascadeType.ALL)
	private List<Email> email_associado = new ArrayList<>();

	public NumeroDaSorte(Integer numero, List<Email> email_associado) {
		super();
		this.numero = numero;
		this.email_associado = email_associado;
	}
}



