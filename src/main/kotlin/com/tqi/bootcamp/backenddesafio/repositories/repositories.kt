package com.tqi.bootcamp.backenddesafio.repositories

import com.tqi.bootcamp.backenddesafio.entities.Categoria
import com.tqi.bootcamp.backenddesafio.entities.Produto
import org.springframework.data.repository.CrudRepository



interface CategoriaRepository : CrudRepository<Categoria, Long> {

}

interface ProdutoRepository : CrudRepository<Produto, Long> {

}