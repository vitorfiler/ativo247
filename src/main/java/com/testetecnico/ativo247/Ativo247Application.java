package com.testetecnico.ativo247;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.ContextLoader;

import com.testetecnico.ativo247.config.JWTAuthorizationFilter;
import com.testetecnico.ativo247.model.Usuario;
import com.testetecnico.ativo247.repository.UsuarioRepository;
import com.testetecnico.ativo247.service.UsuarioService;

@SpringBootApplication
public class Ativo247Application {

	public static void main(String[] args) {
		SpringApplication.run(Ativo247Application.class, args);
	}


	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.POST, "/usuario").permitAll()
				.anyRequest().authenticated();
		}
	}
}
