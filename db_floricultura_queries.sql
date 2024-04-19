create database db_floricultura;

use db_floricultura;

create table cliente (
	idCliente integer primary key auto_increment,
    rg varchar(12) not null unique,
    nome varchar(255) not null,
    telefone varchar(11) not null,
    endereco varchar(255) not null    
);

desc cliente;

create table produto(
	idProduto integer primary key auto_increment,
    nome varchar(45) not null,
    tipo varchar (45) not null,
    quantidadeEstoque integer
);

desc produto;

create table pedido(
idPedido integer primary key auto_increment,
dataPedido date not null,
valorTotal double not null,
fk_cliente integer not null
);

alter table pedido add constraint fk_pedido_cliente 
foreign key (fk_cliente) references cliente(idCliente);

create table pedido_has_produto(
fk_pedido integer not null,
fk_produto integer not null
);

alter table pedido_has_produto add constraint fk_pedido_has_produto_pedido 
foreign key (fk_pedido) references pedido(idPedido);

alter table pedido_has_produto add constraint fk_pedido_has_produto_produto
foreign key (fk_produto) references produto(idProduto);

/* MANIPULAR DADOS */

insert into cliente values 
(NULL, "6516516", "Princesa Isabel", "04791616511", "Rua dos Católicos, n 10"), 
(NULL, "9816561", "Dom Miguel", "04791656333", "Rua dos Reis, n 20"),
(NULL, "8215261", "Dom Manoel", "04791656444", "Rua dos Cristãos, n 30");

SELECT * FROM cliente;

insert into produto values 
(NULL, "Margaridas", "Flor", 20),
(NULL, "Porcelana", "Vaso", 3),
(NULL, "Rosas", "Flor", 50);

SELECT * FROM produto;

alter table produto add preco double not null after tipo;

insert into pedido values 
(null, '2024-04-11', 590.90, 1),
(null, '2024-04-18', 113.90, 2);

update produto set preco = 4.99 where idProduto = 1;

update produto set preco = 150.90 where idProduto = 2;

update produto set preco = 6.99 where idProduto = 3;

select * from pedido;

insert into pedido_has_produto values 
(1, 1),
(1, 2),
(2, 2);

/* COMANDOS DQL */

SELECT * FROM produto;
SELECT COUNT(idProduto) 'Quantidade' FROM produto;

SELECT * FROM pedido;
SELECT SUM(valorTotal) 'Total (R$)' FROM pedido;

SELECT MAX(valorTotal) 'Maior pedido'FROM pedido;

SELECT MIN(valorTotal) 'Menor pedido' FROM pedido;

SELECT AVG(valorTotal) 'Média' from pedido;

SELECT idPedido, dataPedido 'Data da compra', nome 'Nome produto', preco 'Preço (R$)' FROM pedido_has_produto
INNER JOIN pedido
ON pedido_has_produto.fk_pedido = pedido.idPedido
INNER JOIN produto
on pedido_has_produto.fk_produto = produto.idProduto;

SELECT idPedido, COUNT(nome) 'Quantidade de produtos' FROM pedido_has_produto
INNER JOIN pedido
ON pedido_has_produto.fk_pedido = pedido.idPedido
INNER JOIN produto
ON pedido_has_produto.fk_produto = produto.idProduto
GROUP BY nome;

SELECT produto.nome, COUNT(pedido.idPedido) 'Quantidade de produtos' FROM pedido_has_produto
INNER JOIN pedido
ON pedido_has_produto.fk_pedido = pedido.idPedido
INNER JOIN produto
ON pedido_has_produto.fk_produto = produto.idProduto
GROUP BY nome;

