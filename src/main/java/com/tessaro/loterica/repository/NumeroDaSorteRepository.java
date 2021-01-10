package com.tessaro.loterica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tessaro.loterica.model.NumeroDaSorte;

public interface NumeroDaSorteRepository extends JpaRepository<NumeroDaSorte, Long> {

	List<NumeroDaSorte> findByNumero(Integer numero);
	
}