package com.testetecnico.ativo247.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testetecnico.ativo247.model.Paciente;

@Service
public interface LoginService {

	public Paciente autenticacao(String username, String password) throws UsernameNotFoundException;
}
