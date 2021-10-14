CREATE TABLE Usuario (
	id INT AUTO_INCREMENT,
	nome VARCHAR (100),
	telefone VARCHAR(20),
	sexo VARCHAR(1),
	cpf VARCHAR(11),
	senha VARCHAR(100),
	PRIMARY KEY (id)	
);

CREATE TABLE Medico (
	id INT AUTO_INCREMENT,
	nome VARCHAR (100),
	nuCrm VARCHAR(20),
	PRIMARY KEY (id)	
);

CREATE TABLE Endereco (
	id INT AUTO_INCREMENT,
	logradouro VARCHAR (200),
	numero INT,
	bairro VARCHAR(100),
	complemento VARCHAR(100),
	cidade VARCHAR(20),
	estado VARCHAR(10),
	cep VARCHAR(8),
	PRIMARY KEY (id)	
);

CREATE TABLE Paciente (
	id INT AUTO_INCREMENT,
	nome VARCHAR (100),
	nomeMedico VARCHAR(100),
	cpf VARCHAR(11),
	dtPrescricao Date,
	telefone VARCHAR(20),
	observacao VARCHAR(500),
	ativo BIT,
	enderecoID INT,
	medicoID INT,
	PRIMARY KEY (id),
    FOREIGN KEY (medicoID) REFERENCES Medico(id),
    FOREIGN KEY (enderecoID) REFERENCES Endereco(id)
);