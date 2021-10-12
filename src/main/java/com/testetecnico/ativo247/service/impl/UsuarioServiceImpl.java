package com.testetecnico.ativo247.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testetecnico.ativo247.model.Usuario;
import com.testetecnico.ativo247.repository.UsuarioRepository;
import com.testetecnico.ativo247.service.UsuarioService;

@Component("UsuarioController")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository pacienteRepository;
	
	public Usuario salvarUsuario(Usuario usuario) throws Exception {
		Usuario pacienteResponse = pacienteRepository.findByCpf(usuario.getCpf());
		if(pacienteResponse == null) {				
			pacienteRepository.save(usuario);
			return usuario;
		}else {				
			throw new IllegalArgumentException("Usuário com cpf "+usuario.getCpf()+" Já existe no sistema!");
		}
	}
}
