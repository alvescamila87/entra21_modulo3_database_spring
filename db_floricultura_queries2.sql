CREATE DATABASE db_floricultura;

USE db_floricultura;

CREATE TABLE cliente(
    id_cliente INTEGER PRIMARY KEY AUTO_INCREMENT,
    rg VARCHAR(12) NOT NULL UNIQUE,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    endereco VARCHAR(255) NOT NULL
);

CREATE TABLE produto(
    id_produto bigint PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    tipo VARCHAR(45) NOT NULL,
    quantidade_estoque INTEGER
);

ALTER TABLE produto ADD preco DOUBLE NOT NULL;

CREATE TABLE pedido(
    id_pedido INTEGER PRIMARY KEY AUTO_INCREMENT,
    data_pedido DATE NOT NULL,
    valor_total DOUBLE NOT NULL,
    fk_cliente INTEGER NOT NULL
);

ALTER TABLE pedido ADD CONSTRAINT fk_pedido_cliente 
FOREIGN KEY (fk_cliente) REFERENCES cliente(id_cliente);

CREATE TABLE pedido_has_produto(
    fk_pedido bigint NOT NULL,
    fk_produto bigint NOT NULL
);

ALTER TABLE pedido_has_produto 
ADD CONSTRAINT fk_pedido_has_produto_pedido 
FOREIGN KEY (fk_pedido) REFERENCES pedido(id_pedido);

ALTER TABLE pedido_has_produto 
ADD CONSTRAINT fk_pedido_has_produto_produto 
FOREIGN KEY (fk_produto) REFERENCES produto(id_produto);

/* MANIPULAR DADOS /

INSERT INTO cliente VALUES
(NULL, "1234567890", "Antonio Carlos", "01111222", "Rua Sem Fim, n 10"),
(NULL, "1234567892", "Paula Fernandes", "01111223", "Av. Movimentada, n 10");

SELECT FROM cliente;

INSERT INTO produto VALUES
(null, "Rosa", "Flor", 20, 5.99),
(null, "Margarida", "Flor", 15, 4.99);

SELECT * FROM produto;

INSERT INTO pedido VALUES
(NULL, '2024-04-11', 50.0, 1);

SELECT * FROM pedido;

INSERT INTO pedido_has_produto VALUES
(1, 1),
(1, 2);

show create table pedido_has_produto;