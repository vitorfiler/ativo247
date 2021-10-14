package com.testetecnico.ativo247.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity(name="Medico")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	@NotNull
	private String nome;
	
	@Column(name="nu_crm")
	@NotNull
	private String nuCrm;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNuCrm() {
		return nuCrm;
	}
	public void setNuCrm(String nuCrm) {
		this.nuCrm = nuCrm;
	}
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medico(Long id, String nome, String nuCrm) {
		super();
		this.id = id;
		this.nome = nome;
		this.nuCrm = nuCrm;
	}
}
