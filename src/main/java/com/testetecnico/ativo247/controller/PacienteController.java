package com.testetecnico.ativo247.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnico.ativo247.model.Paciente;
import com.testetecnico.ativo247.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	PacienteService pacienteService;
	
	@PostMapping
	public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) throws Exception{
		return new ResponseEntity<>(pacienteService.salvarPaciente(paciente), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Optional<Paciente>> buscarPaciente(@RequestParam(name = "id") Long id){
		return new ResponseEntity<>(pacienteService.buscarPaciente(id), HttpStatus.OK);
	}
	
	@GetMapping("buscarTodos")
	public ResponseEntity<List<Paciente>> buscarTodosPacientes(){
		return new ResponseEntity<>(pacienteService.buscarTodosPacientes(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Paciente> atualizarPaciente(@RequestBody Paciente paciente) throws Exception{
		return new ResponseEntity<>(pacienteService.atualizarPaciente(paciente), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletarPaciente(@RequestParam(name = "id") Long id) throws Exception{
		return new ResponseEntity<>(pacienteService.deletarPaciente(id), HttpStatus.NO_CONTENT);
	}
}
