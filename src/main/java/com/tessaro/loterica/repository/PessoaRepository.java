package com.tessaro.loterica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tessaro.loterica.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
