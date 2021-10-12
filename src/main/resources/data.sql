
INSERT INTO Usuario (id, nome, telefone, sexo, cpf, senha) 
VALUES (1, 'Vítor Nunes', '34984112242', 'M', '00000000000', '12345');

INSERT INTO Medico (id, nome, nuCrm) 
VALUES (1, 'Vítor Nunes', 177696);

INSERT INTO Endereco (id, logradouro, numero, bairro, complemento, cidade, estado, cep) 
VALUES (1, 'Estrada Dário Manoel Garcia', '1206', 'Ingleses do Rio Vermelho', 'Bloco B ap 207"', 'Florianópolis', 'SC', '88058400');

INSERT INTO Paciente (id, nome, nomeMedico , cpf , dtPrescricao , telefone, observacao, ativo, enderecoID, medicoID) 
VALUES (1, 'Vítor Nunes', 'Maria das Graças', '14100000000', '2021-10-11', '34984112242', 'OBSERVAÇÃO', 1, 1, 1);