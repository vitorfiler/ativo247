package com.testetecnico.ativo247.service;

import org.springframework.stereotype.Service;

import com.testetecnico.ativo247.model.Medico;

@Service
public interface MedicoService {

	public Medico salvarMedico(Medico medico) throws Exception;
}
