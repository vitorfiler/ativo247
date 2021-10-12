package com.testetecnico.ativo247.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetecnico.ativo247.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	Paciente findByCpf (String cpf);
}
