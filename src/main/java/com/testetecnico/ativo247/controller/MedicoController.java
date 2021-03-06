package com.testetecnico.ativo247.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnico.ativo247.dto.MedicoDTO;
import com.testetecnico.ativo247.model.Medico;
import com.testetecnico.ativo247.service.MedicoService;

@RestController
@RequestMapping("medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MedicoDTO salvarMedico(@RequestBody Medico medico) throws Exception{
		return medicoService.salvarMedico(medico);
	}
	
	@GetMapping("todos")
	public ResponseEntity<List<Medico>> buscarMedicos() throws Exception{
		return new ResponseEntity<>(medicoService.buscarMedicos(), HttpStatus.OK);
	}
	
}
