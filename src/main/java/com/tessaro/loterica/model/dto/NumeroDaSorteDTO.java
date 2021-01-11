package com.tessaro.loterica.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private List<EmailDTO> email_associado = new ArrayList<>();

}
