package com.tessaro.loterica.config.usuario;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tessaro.loterica.config.security.UserSS;
import com.tessaro.loterica.config.usuario.DTO.UserDTO;
import com.tessaro.loterica.exceptionhandler.RepetidoExcepetion;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public UserDTO salvar (UserDTO user){
		User usuario= new User();
		
		BeanUtils.copyProperties(user, usuario, "id", "perfis");
		usuario.setPassword(pe.encode(usuario.getPassword()));
		User usuarioSalvo = repository.save(usuario);
		BeanUtils.copyProperties(usuarioSalvo, user, "password");
		return user;
	}

	public void cadastrarPerfil(String email, Integer perfil) {

			User user = repository.findByEmail(email).get(0);
			if(user.getPerfis().contains(Perfil.toEnum(perfil))) {
				throw new RepetidoExcepetion();
			}
			if (user != null) {
			user.addPerfil(Perfil.toEnum(perfil));
			repository.save(user);
			}
	}
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
		
	}
}
