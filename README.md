# Gerador_Senhas

Banco de dados:

create database gerador_senha;

use gerador_senha;

create table usuario(
	id INT NOT NULL PRIMARY key auto_increment,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL
);
