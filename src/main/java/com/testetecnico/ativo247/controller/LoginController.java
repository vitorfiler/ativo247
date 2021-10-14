package com.testetecnico.ativo247.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnico.ativo247.model.Login;
import com.testetecnico.ativo247.model.Usuario;
import com.testetecnico.ativo247.service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Login> login(@RequestBody Map<String, String> parametros) {
		String usuarioCpf = parametros.get("usuario");
		String senha = parametros.get("senha");
		Usuario paciente = loginService.autenticacao(usuarioCpf, senha);
		String token = getJWTToken(usuarioCpf);
		Login user = new Login();
		user.setToken(token);
		user.setUsuario(paciente.getNome());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
