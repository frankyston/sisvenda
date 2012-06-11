CREATE TABLE cliente (id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, email varchar(100), telefone varchar(10), cpf varchar(11))

CREATE TABLE funcionario (id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, nome varchar(100), email varchar(100), telefone varchar(10), salario varchar(10))

CREATE TABLE users (id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, nome varchar(100), email varchar(100), telefone varchar(10), login varchar(30), senha varchar(30));

CREATE TABLE venda (id int(11) NOT NULL AUTO_INCREMENT, funcionario varchar(100), cliente varchar(100), produto varchar(100), pagamento double(5,2))
