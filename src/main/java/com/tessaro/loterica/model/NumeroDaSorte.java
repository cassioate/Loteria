package com.tessaro.loterica.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class NumeroDaSorte {

	@Id
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "email_associado_id")
	private Email email_associado;
	
//	@OneToOne(mappedBy = "vencedor")
//	private Vencedores ganhador;

	public NumeroDaSorte(Long id, Email email_associado) {
		super();
		this.id = id;
		this.email_associado = email_associado;
	}

}
