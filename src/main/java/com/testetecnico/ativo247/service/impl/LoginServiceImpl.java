package com.testetecnico.ativo247.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.testetecnico.ativo247.model.Usuario;
import com.testetecnico.ativo247.repository.UsuarioRepository;
import com.testetecnico.ativo247.service.LoginService;

@Component("LoginController")
public class LoginServiceImpl implements LoginService{

	@Autowired
	UsuarioRepository pacienteRepository;
	
	public Usuario autenticacao(String username, String password) throws UsernameNotFoundException {
		try {			
			Usuario paciente = pacienteRepository.findByCpf(username);
			if(paciente != null && paciente.getCpf().equals(username) && paciente.getSenha().equals(password)) {			
				return paciente;
			}
			else {
				throw new UsernameNotFoundException("Usuário com cpf: " + username + "não encontrado.");
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("Falha no login ");
		}
	}
}
