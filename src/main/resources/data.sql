 DROP TABLE IF EXISTS cliente;

 CREATE TABLE cliente (
   id INT AUTO_INCREMENT  PRIMARY KEY,
   nome VARCHAR(250) NOT NULL,
   email VARCHAR(250) NOT NULL );

 INSERT INTO cliente (nome, email) VALUES
 ('Marcio Correia de Oliveira', 'marcio.c@gmail.com'),
 ('João Miguel Primo', 'jm@gmail.com'),
 ('Malvina Sousa Lima', 'malvina.sousa@gmail.com');

DROP TABLE IF EXISTS produto;

CREATE TABLE produto (
id INT AUTO_INCREMENT  PRIMARY KEY,
descricao VARCHAR(250) NOT NULL,
estoque INTEGER NOT NULL,
valor NUMERIC NOT NULL);

INSERT INTO produto (descricao, estoque, valor) VALUES
('Televisão', 10, 6000),
('Computador', 15, 3000),
('Celular', 20, 5000);