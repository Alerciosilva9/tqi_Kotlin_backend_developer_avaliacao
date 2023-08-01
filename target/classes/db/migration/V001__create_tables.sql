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





