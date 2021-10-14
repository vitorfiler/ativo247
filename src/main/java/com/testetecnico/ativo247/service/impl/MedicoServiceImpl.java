package com.testetecnico.ativo247.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testetecnico.ativo247.dto.MedicoDTO;
import com.testetecnico.ativo247.model.Medico;
import com.testetecnico.ativo247.repository.MedicoRepository;
import com.testetecnico.ativo247.service.MedicoService;

@Component("MedicoController")
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public MedicoDTO salvarMedico(Medico medico) throws Exception {
		try {
			return objectMapper.convertValue(medicoRepository.save(medico), MedicoDTO.class) ;
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao cadastrar médico!");
		}
	}

	public List<Medico> buscarMedicos() throws Exception {
		return medicoRepository.findAll();
	}

}
