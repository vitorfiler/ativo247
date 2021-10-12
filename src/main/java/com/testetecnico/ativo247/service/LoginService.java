package com.testetecnico.ativo247.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testetecnico.ativo247.model.Usuario;

@Service
public interface LoginService {

	public Usuario autenticacao(String username, String password) throws UsernameNotFoundException;
}
