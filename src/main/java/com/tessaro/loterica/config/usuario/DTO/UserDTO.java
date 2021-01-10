package com.tessaro.loterica.config.usuario.DTO;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserDTO {
	
	private Long id;

	@NotNull
	@Length(min = 4, max = 20)
	private String email;
	
	@NotNull
	@Length(min = 4, max = 30)
	private String password;

	public UserDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
}
