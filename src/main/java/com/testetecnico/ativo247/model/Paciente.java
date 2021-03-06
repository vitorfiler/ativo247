package com.testetecnico.ativo247.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity(name="Paciente")
@Table
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@NotNull
	private String nome;
	
	@NotNull
	private Long medicoID;
	
	@NotNull
	private String nomeMedico;
	
	@NotNull
	private String cpf;
	
	@NotNull
	private LocalDate dtPrescricao;
	
	@NotNull
	private String telefone;
	
	@NotNull
	private String observacao;
	
	@NotNull
	private boolean ativo;
	
	@OneToOne
	@JoinColumn(name="enderecoID", referencedColumnName="id")
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
}
