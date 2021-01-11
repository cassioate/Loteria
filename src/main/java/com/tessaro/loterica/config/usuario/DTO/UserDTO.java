package com.tessaro.loterica.config.usuario.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;
import com.tessaro.loterica.service.annotations.UserValido;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@UserValido
public class UserDTO {
	
	private Long id;

	@Email
	@NotNull
	@Length(min = 4, max = 20)
	private String email;
	
	@NotNull
	@Length(min = 4, max = 30)
	private String password;
	
	private Set<Integer> perfis = new HashSet<Integer>();

	public UserDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
}
