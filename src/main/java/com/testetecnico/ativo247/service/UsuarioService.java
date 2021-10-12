package com.testetecnico.ativo247.service;

import org.springframework.stereotype.Service;

import com.testetecnico.ativo247.model.Usuario;

@Service
public interface UsuarioService {

	public Usuario salvarUsuario(Usuario usuario) throws Exception;
	
}
