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
@RequestMapping("cep")
public class CepController {

	@Autowired
	private MedicoService medicoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<Medico>> consultaCep() throws Exception{
		return new ResponseEntity<>(medicoService.buscarMedicos(), HttpStatus.OK);
	}
	
}
