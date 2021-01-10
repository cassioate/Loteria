package com.tessaro.loterica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tessaro.loterica.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
	
	List<Email> findByEmail(String email);
}
