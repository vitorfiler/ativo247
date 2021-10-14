package com.testetecnico.ativo247.service;

import java.io.IOException;
import java.net.ProtocolException;

import org.springframework.stereotype.Service;

import com.testetecnico.ativo247.dto.Cep;


@Service
public interface CepService {

	public Cep consultaCep(String cep) throws IOException;
}
