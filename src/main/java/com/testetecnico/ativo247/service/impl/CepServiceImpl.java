package com.testetecnico.ativo247.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.testetecnico.ativo247.dto.Cep;
import com.testetecnico.ativo247.service.CepService;

@Component("CepController")
public class CepServiceImpl implements CepService{

    @Override
    public Cep consultaCep(String cep) throws IOException{
        
        URL url;
		try {
			url = new URL("http://viacep.com.br/ws/" + cep + "/json/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			return null;
		} catch (MalformedURLException e) {
			throw new IOException();
		}
    }
    

}
