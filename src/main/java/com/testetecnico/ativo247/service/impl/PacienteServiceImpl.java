package com.testetecnico.ativo247.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testetecnico.ativo247.model.Medico;
import com.testetecnico.ativo247.model.Paciente;
import com.testetecnico.ativo247.repository.EnderecoRepository;
import com.testetecnico.ativo247.repository.MedicoRepository;
import com.testetecnico.ativo247.repository.PacienteRepository;
import com.testetecnico.ativo247.service.PacienteService;

@Component("PacienteController")
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	MedicoRepository medicoRepository;
	
	public Paciente salvarPaciente(Paciente paciente) throws Exception {
		Paciente pacienteResponse = pacienteRepository.findByCpf(paciente.getCpf());
		Optional<Medico> medico = medicoRepository.findById(paciente.getMedicoID());
		paciente.setNomeMedico(medico.get().getNome());
		if(pacienteResponse == null) {
			enderecoRepository.save(paciente.getEndereco());
			pacienteRepository.save(paciente);
			return paciente;
		}else {				
			throw new IllegalArgumentException("Paciente com cpf "+paciente.getCpf()+" Já existe no sistema!");
		}
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
				throw new Exception("Paciente com cpf "+paciente.getCpf()+" não foi encontrado!");
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
