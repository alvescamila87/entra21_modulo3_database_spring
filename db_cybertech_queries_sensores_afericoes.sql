create database db_cybertech;

use db_cybertech;

create table sensores (
	codigo int not null,
    modelo varchar(45),
    dataUltimaChecagem datetime,
    locacalizao varchar(25)
);

desc sensores;

alter table sensores modify column modelo varchar(45) not null;

alter table sensores drop column locacalizao;

alter table sensores add localizacao varchar (25) after dataUltimaChecagem;

create table afericoes (
codigo int not null,
data date not null,
hora time not null,
temperatura decimal(3,2),
sensor int not null,
primary key (codigo)
);

alter table afericoes modify column sensor int;

alter table afericoes add foreign key (sensor) references sensores (codigo) on delete set null on update cascade;

alter table afericoes modify column temperatura decimal(2,2);

desc afericoes;


