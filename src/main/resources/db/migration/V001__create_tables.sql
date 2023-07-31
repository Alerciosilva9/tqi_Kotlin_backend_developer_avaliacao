create schema if not exists mercearia;

create table mercearia.categoria(
    id BIGSERIAL PRIMARY KEY,
    nome varchar(40) UNIQUE NOT NULL
);

create table mercearia.produto(
    id BIGSERIAL PRIMARY KEY,
    nome_produto varchar(40) NOT NULL,
    id_categoria INTEGER NOT NULL,
    unidade_medida varchar(20)NOT NULL,
    preco_unitario FLOAT4 NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES mercearia.categoria(id)
);

CREATE TYPE forma AS ENUM ('Cartão crédito','Cartão débito', 'Dinheiro', 'pix');

create table mercearia.venda(
     id BIGSERIAL PRIMARY KEY,
     valor FLOAT4  NOT NULL,
     forma_pagamento forma NOT NULL
);

create table mercearia.vendaproduto(
    produto_id SERIAL,
    venda_id SERIAL,
    quantidade INTEGER NOT NULL,
    FOREIGN KEY (produto_id) references mercearia.produto(id),
    FOREIGN KEY (venda_id) references mercearia.venda(id),
    PRIMARY KEY (produto_id,venda_id)
);




