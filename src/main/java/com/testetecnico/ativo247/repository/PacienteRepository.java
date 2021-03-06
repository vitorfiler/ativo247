package com.testetecnico.ativo247.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testetecnico.ativo247.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	Paciente findByCpf (String cpf);
}
