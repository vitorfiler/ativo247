package com.testetecnico.ativo247.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnico.ativo247.dto.PacienteDTO;
import com.testetecnico.ativo247.model.Paciente;
import com.testetecnico.ativo247.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	PacienteService pacienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PacienteDTO salvarPaciente(@RequestBody Paciente paciente) throws Exception{
		return pacienteService.salvarPaciente(paciente);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public PacienteDTO buscarPaciente(@RequestParam(name = "id") Long id){
		return pacienteService.buscarPaciente(id);
	}
	
	@GetMapping("todos")
	@ResponseStatus(HttpStatus.OK)
	public List<Paciente> buscarTodosPacientes(){
		return pacienteService.buscarTodosPacientes();
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public PacienteDTO atualizarPaciente(@RequestBody Paciente paciente) throws Exception{
		return pacienteService.atualizarPaciente(paciente);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public PacienteDTO deletarPaciente(@RequestParam(name = "id") Long id) throws Exception{
		return pacienteService.deletarPaciente(id);
	}
	
	@GetMapping("filtro")
	@ResponseStatus(HttpStatus.OK)
	public List<Paciente> filtrarPacientes(@RequestParam(name = "filtro") String filtro){
		return pacienteService.filtrarPacientes(filtro);
	}
}
