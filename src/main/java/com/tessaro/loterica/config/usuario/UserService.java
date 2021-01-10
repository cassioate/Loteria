package com.tessaro.loterica.config.usuario;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.config.usuario.DTO.UserDTO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public UserDTO salvar (UserDTO user){
		User usuario= new User();
		BeanUtils.copyProperties(user, usuario, "id");
		usuario.setPassword(pe.encode(usuario.getPassword()));
		User usuarioSalvo = repository.save(usuario);
		BeanUtils.copyProperties(usuarioSalvo, user, "password");
		return user;
	}
	
	public void acessar (UserDTO user) {
		User usuario= new User();
		BeanUtils.copyProperties(user, usuario, "id");
		
		User usuarioLogado = repository.findById(user.getId()).get();
		
		if (usuarioLogado != null) {
			pe.matches(user.getPassword(), usuarioLogado.getPassword());
		}
		
	}
	
}
