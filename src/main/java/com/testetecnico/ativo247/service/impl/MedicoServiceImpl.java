package com.testetecnico.ativo247.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testetecnico.ativo247.model.Medico;
import com.testetecnico.ativo247.repository.MedicoRepository;
import com.testetecnico.ativo247.service.MedicoService;

@Component("MedicoController")
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	MedicoRepository medicoRepository;
	
	public Medico salvarMedico(Medico medico) throws Exception {
		try {
			medicoRepository.save(medico);
			return medico;
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao cadastrar médico!");
		}
	}

}
