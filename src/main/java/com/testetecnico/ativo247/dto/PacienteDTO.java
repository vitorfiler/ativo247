package com.testetecnico.ativo247.dto;

import java.time.LocalDate;

import com.testetecnico.ativo247.model.Endereco;

public class PacienteDTO {

	private Long id;
	private String nome;
	private Long medicoID;
	private String nomeMedico;
	private String cpf;
	private LocalDate dtPrescricao;
	private String telefone;
	private String observacao;
	private boolean ativo;
	private Endereco endereco;

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

	public Long getMedicoID() {
		return medicoID;
	}

	public void setMedicoID(Long medicoID) {
		this.medicoID = medicoID;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDtPrescricao() {
		return dtPrescricao;
	}

	public void setDtPrescricao(LocalDate dtPrescricao) {
		this.dtPrescricao = dtPrescricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public PacienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
