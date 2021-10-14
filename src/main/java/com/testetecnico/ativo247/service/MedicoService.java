package com.testetecnico.ativo247.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testetecnico.ativo247.dto.MedicoDTO;
import com.testetecnico.ativo247.model.Medico;

@Service
public interface MedicoService {

	public MedicoDTO salvarMedico(Medico medico) throws Exception;
	
	public List<Medico> buscarMedicos() throws Exception;
}
