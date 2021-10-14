package com.testetecnico.ativo247.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testetecnico.ativo247.dto.PacienteDTO;
import com.testetecnico.ativo247.model.Paciente;

@Service
public interface PacienteService {

	public PacienteDTO salvarPaciente(Paciente paciente) throws Exception;
	
	public PacienteDTO buscarPaciente(Long id);
	
	public List<Paciente> buscarTodosPacientes();
	
	public PacienteDTO atualizarPaciente(Paciente paciente) throws Exception;
	
	public PacienteDTO deletarPaciente(Long id) throws Exception;
	
	public List<Paciente> filtrarPacientes(String filtro);
}
