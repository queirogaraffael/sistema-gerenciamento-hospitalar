CREATE DATABASE hospital;


CREATE TABLE pacientes(
    cpf VARCHAR(11),
    nome VARCHAR(50),
    idade INT,
    endereco VARCHAR(70),
    telefone VARCHAR(20),
    
    PRIMARY KEY(CPF)

);

CREATE TABLE medicos (
    crm VARCHAR(13),
    nome VARCHAR(50),
    especialidade VARCHAR(20),
    telefone VARCHAR(20),
    
    PRIMARY KEY (CRM)
);
