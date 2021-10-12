package com.testetecnico.ativo247.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetecnico.ativo247.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
	
}
