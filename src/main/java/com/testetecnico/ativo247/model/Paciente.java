package com.testetecnico.ativo247.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	private String nome;
	private Long medicoID;
	private String nomeMedico;
	private String cpf;
	private LocalDate dtPrescricao;
	private String telefone;
	private String observacao;
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name="Endereco")
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

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(Long id, String nome, Long medicoID, String nomeMedico, String cpf, LocalDate dtPrescricao,
			String telefone, String observacao, boolean ativo, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.medicoID = medicoID;
		this.nomeMedico = nomeMedico;
		this.cpf = cpf;
		this.dtPrescricao = dtPrescricao;
		this.telefone = telefone;
		this.observacao = observacao;
		this.ativo = ativo;
		this.endereco = endereco;
	}
}
