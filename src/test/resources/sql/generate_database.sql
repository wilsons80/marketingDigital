use mdigital

create table usuario(
	idUsuario int not null IDENTITY  ,
	nmUsername varchar(250) not null,
	txSenha varchar(10) not null,
	stAtivo char(1) not null default 'N',
	qtTentativasLogin int default 0,
	primary key (idUsuario)
);

insert into usuario(nmUsername,txSenha,stAtivo,qtTentativasLogin) 
  values('wilson.carvalho', '123', 'S', 0);

create table cliente(
	idCliente int not null IDENTITY  ,
	nmNome varchar(250) not null,
	nrDDD numeric(2),
	nrTelefone varchar(9),
	dsEmail varchar(250) not null,
    vlRendaBrutaMensal numeric(8,2)
	primary key(idCliente)
);

create table mala_direta(
    idMalaDireta int not null IDENTITY  ,
	nmNome varchar(250) not null,
	vlFaixaRendaInicial numeric(8,2) not null,
	vlFaixaRendaFinal numeric(8,2) not null,
	primary key(idMalaDireta)
);