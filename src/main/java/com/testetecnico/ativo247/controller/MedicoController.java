package com.testetecnico.ativo247.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnico.ativo247.model.Medico;
import com.testetecnico.ativo247.service.MedicoService;

@RestController
@RequestMapping("medico")
public class MedicoController {

	@Autowired
	MedicoService medicoService;
	
	@PostMapping
	public ResponseEntity<Medico> salvarMedico(@RequestBody Medico medico) throws Exception{
		return new ResponseEntity<>(medicoService.salvarMedico(medico), HttpStatus.OK);
	}
}
