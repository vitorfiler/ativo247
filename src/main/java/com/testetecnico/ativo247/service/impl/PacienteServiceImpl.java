package com.testetecnico.ativo247.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testetecnico.ativo247.model.Paciente;
import com.testetecnico.ativo247.repository.PacienteRepository;
import com.testetecnico.ativo247.service.PacienteService;

@Component("PacienteController")
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	PacienteRepository pacienteRepository;
	
	public Paciente salvarPaciente(Paciente paciente) {
		pacienteRepository.save(paciente);
		return paciente;
	}
	
	public Optional<Paciente> buscarPaciente(Long id) {
		return pacienteRepository.findById(id);
	}
	
	public List<Paciente> buscarTodosPacientes(){
		return pacienteRepository.findAll();
	}
	
	public Paciente atualizarPaciente(Paciente paciente) throws Exception {
		Optional<Paciente> pacienteResponse = pacienteRepository.findById(paciente.getId());
		try {
			if(pacienteResponse != null) {
				pacienteRepository.save(paciente);
				return paciente;
			}else {
				throw new Exception("Usuário com cpf "+paciente.getCpf()+" não foi encontrado!");
			}
		} catch (Exception e) {
			throw new Exception("Falha ao atualizar paciente com o cpf "+paciente.getCpf());
		}
		
	}
	
	public String deletarPaciente(Long id) throws Exception {
		try {			
			pacienteRepository.deleteById(id);
			return "Paciente Deletado com sucesso!";
		} catch (Exception e) {
			throw new Exception("Falha ao deletar paciente");
		}
	}
	
}
