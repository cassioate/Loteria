package com.tessaro.loterica.config.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByEmail(String email);
	
}
