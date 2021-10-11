package com.testetecnico.ativo247.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.testetecnico.ativo247.model.Paciente;

@Service
public interface PacienteService {

	public Paciente salvarPaciente(Paciente paciente);
	
	public Optional<Paciente> buscarPaciente(Long id);
	
	public Paciente atualizarPaciente(Paciente paciente) throws Exception;
	
	public String deletarPaciente(Long id) throws Exception;
	
	public List<Paciente> buscarTodosPacientes();
}
