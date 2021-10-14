package com.testetecnico.ativo247.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testetecnico.ativo247.dto.PacienteDTO;
import com.testetecnico.ativo247.exceptions.NotFoundException;
import com.testetecnico.ativo247.model.Endereco;
import com.testetecnico.ativo247.model.Medico;
import com.testetecnico.ativo247.model.Paciente;
import com.testetecnico.ativo247.repository.EnderecoRepository;
import com.testetecnico.ativo247.repository.MedicoRepository;
import com.testetecnico.ativo247.repository.PacienteRepository;
import com.testetecnico.ativo247.service.PacienteService;

@Component("PacienteController")
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public PacienteDTO salvarPaciente(Paciente paciente) throws Exception {
		Paciente pacienteResponse = pacienteRepository.findByCpf(paciente.getCpf());
		Optional<Medico> medico = medicoRepository.findById(paciente.getMedicoID());
		paciente.setNomeMedico(medico.get().getNome());
		if(pacienteResponse == null) {
			enderecoRepository.save(paciente.getEndereco());
			Optional<Endereco> endereco = enderecoRepository.findById(paciente.getEndereco().getId());
//			paciente.setEnderecoID(endereco.get().getId());
			pacienteRepository.save(paciente);
			return objectMapper.convertValue(pacienteRepository.save(paciente), PacienteDTO.class);
		}else {				
			throw new IllegalArgumentException("Paciente com cpf "+paciente.getCpf()+" Já existe no sistema!");
		}
	}
	

	public PacienteDTO buscarPaciente(Long id) {
		return objectMapper.convertValue(pacienteRepository.findById(id).orElseThrow(()->new NotFoundException()), PacienteDTO.class);
	}
	
	@SuppressWarnings("static-access")
	public List<Paciente> buscarTodosPacientes(){
		
		List<Paciente> pacientes = pacienteRepository.findAll();
		pacientes.forEach(paciente->{
			Optional<Medico> medico = medicoRepository.findById(paciente.getMedicoID());
			String nomeMedico = medico.ofNullable(medico.get().getNome()).orElse("");
			paciente.setNomeMedico(nomeMedico);
		});
		return pacientes;
	}
	
	public List<Paciente> filtrarPacientes(String filtro){
		List<Paciente> pacientes = buscarTodosPacientes();
		if(filtro.isEmpty()) {
			return pacientes;
		}
		List<Paciente> pacientesFiltrados = new ArrayList<>();
		pacientes.forEach(paciente->{
			if(paciente.getCpf().toLowerCase().contains(filtro.toLowerCase())) {
				pacientesFiltrados.add(paciente);
			}else if(paciente.getNomeMedico().toLowerCase().contains(filtro.toLowerCase())) {
				pacientesFiltrados.add(paciente);				
			}else if(paciente.getNome().toLowerCase().contains(filtro.toLowerCase())) {
				pacientesFiltrados.add(paciente);								
			}
		});
		return pacientesFiltrados;
	}
	
	public PacienteDTO atualizarPaciente(Paciente paciente) throws Exception {
		Optional<Paciente> pacienteResponse = pacienteRepository.findById(paciente.getId());
		try {
			if(pacienteResponse.isPresent()) {
				return objectMapper.convertValue(pacienteRepository.save(paciente), PacienteDTO.class);
			}else {
				throw new NotFoundException();
			}
		} catch (Exception e) {
			throw new Exception("Falha ao atualizar paciente com o cpf "+paciente.getCpf());
		}
		
	}
	
	public PacienteDTO deletarPaciente(Long id) throws Exception {
		Optional<Paciente> pacienteResponse = pacienteRepository.findById(id);
		try {
			if(pacienteResponse.isPresent()) {
				pacienteResponse.get().setAtivo(false);
				return objectMapper.convertValue(pacienteRepository.save(pacienteResponse.get()), PacienteDTO.class);
			}else {
				throw new NotFoundException();
			}
		} catch (Exception e) {
			throw new Exception("Falha ao deletar paciente com o cpf "+pacienteResponse.get().getCpf());
		}
	}
	
}
