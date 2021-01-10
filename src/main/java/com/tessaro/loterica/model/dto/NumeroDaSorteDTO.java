package com.tessaro.loterica.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tessaro.loterica.model.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class NumeroDaSorteDTO {
	
	@JsonIgnore
	private Long id;
	
	private Integer numero;

	@NotNull
	private List<Email> email_associado = new ArrayList<>();

}
