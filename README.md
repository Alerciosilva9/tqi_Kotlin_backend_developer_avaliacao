# TQI DESAFIO BOOTCAMP - KOTLIN BACKEND DEVELOPER


# DESAFIO AUTO-ATENDIMENTO MERCEARIA JUMARKET

# SOBRE:

Esse projeto é um desafio proposto pela TQI com objetivo de praticar as habilidades aprendidas durante o Bootacmp KOTLIN BACKEND DEVELOPER
, o projeto em questão visa implementar a funcionalidade de auto-atendimento para uma mercearia ficticia chamada Jumarket, o sistema permite o cadastro de Categorias e Produtos e a funcionalidade de compra de produtos.

# Tecnologias usadas
- [X] Kotlin
- [X] Spring Boot
- [X] Spring Web
- [X] Spring Data JPA
- [X] Maven
- [X] Flyway Migration
- [X] JUnit
- [X] PostgreSQL
- [X] Docker


# Como executar o projeto?
 Para executar o projeto é nescessario a instalação da ferramenta Docker, dísponivel em (https://docs.docker.com/get-docker/).

Com o clone do presente repositorio baixado, é nescessario apenas abrir a pasta raiz do repositorio a executar o comamndo a seguir via terminal:
```
    docker-compose up
```

# Endpoints

Para acessar as funcionalidades dísponiveis na presente API, acesse o seguintes endpoints para cada recurso:

## Categorias

### Adicionar uma categoria

Endpoint:
```
http://localhost:8080/categoria
```

Método de requisição: *POST*

HTTP Status se for realizado com sucesso: 200

Retorno: "A categoria cadastrada"

### Exemplo:

#### Requisição
```json
{
    "nome": "Bebidas"
}
```
#### Resposta
```json
{
    "id": 1
    "nome": "Bebidas"
}
```
### Visualizar categorias cadastradas

Endpoint:
```
http://localhost:8080/categoria
```

Método de requisição: *GET*

HTTP Status se for realizado com sucesso: 200

Retorno: "Lista com todas categorias cadastradas, ou uma lista vazia caso não haja nenhuma categoria cadastrada"

### Exemplo:

#### Resposta
```json
{
    "id": 1
    "nome": "Bebidas"
}
{
  "id": 2
  "nome": "Limpeza"
}
{
  "id": 1
  "nome": "Ferramentas"
}
```


## Produtos

### Adicionar uma produto

Endpoint:
```
http://localhost:8080/produto
```

Método de requisição: *POST*

HTTP Status se for realizado com sucesso: 200

Retorno: "O produto cadastrada"

### Exemplo:

#### Requisição
```json
{
  "nome" : "Suco de Caixa",
  "categoria" : 1,
  "unidadeDeMedida" : "LITRO",
  "precoUnitario": 5.99
}
```

### Visualizar Produtos cadastradas

Endpoint:
```
http://localhost:8080/produto
```

Método de requisição: *GET*

HTTP Status se for realizado com sucesso: 200

Retorno: "Lista com todos produtos cadastradas, ou uma lista vazia caso não haja nenhum produto cadastrada"

### Exemplo:

#### Resposta
```json
{
      "id": 1,
      "nome" : "Suco de Caixa",
      "categoria" {
          "id": 1,
          "nome": "Bebidas"
      },
      "unidadeDeMedida" : "LITRO",
      "precoUnitario": 5.99
},
{
      "id": 2,
    "nome" : "Detergente",
    "categoria" {
    "id": 2,
    "nome": "Limpeza"
    },
    "unidadeDeMedida" : "LITRO",
    "precoUnitario": 1.99
  }

```


## Carrinho

### Adicionar um produto no carrinho

Endpoint:
```
http://localhost:8080/carrinho
```

Método de requisição: *POST*

HTTP Status se for realizado com sucesso: 200

### Exemplo:

#### Requisição
```json
{
    "idProduto": 1,
    "quantidade":3,
}

```

### Visualizar Produtos no carrinho

Endpoint:
```
http://localhost:8080/carrinho
```

Método de requisição: *GET*

HTTP Status se for realizado com sucesso: 200

Retorno: "Lista com todos produtos no carrinho , ou uma lista vazia caso não haja nenhuma categoria cadastrada"

### Exemplo:

#### Resposta
```json
{
  "idProduto": 1,
  "quantidade":3,
  "precoTotalItem":3.77
},
{
"idProduto": 2,
"quantidade":3,
"precoTotalItem":123.00
}
```


## Venda

### Finalizar Compra

Endpoint:
```
http://localhost:8080/finalizar
```

Usado para finalizar a compra, no corpo da requisicao, e nescessario somente o metodo de pagamento

Método de requisição: *POST*

HTTP Status se for realizado com sucesso: 200

### Exemplo:

#### Requisição
```json
{
    "forma":"PIX"
}

```

### Visualizar Informacoes do carrinho

Endpoint:
```
http://localhost:8080/carrinho
```
EndPoint Para visualizar preço total da soma de todos os itens no carriho, bem como todos os itens cadastrados


Método de requisição: *GET*

HTTP Status se for realizado com sucesso: 200

Retorno: "preço total da soma de todos os itens , e itens adicionados no carrinho"

### Exemplo:

#### Resposta
```json
{
  "Total Compra":200.00,
  "itens": [
    {
        "idProduto": 1,
        "quantidade":3,
        "precoTotalItem":3.77
    },
    {
      "idProduto": 2,
      "quantidade":3,
      "precoTotalItem":3.77
    }
    
  ]

```
