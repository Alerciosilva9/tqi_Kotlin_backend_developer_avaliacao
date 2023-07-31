package com.tqi.bootcamp.backenddesafio.services

import com.tqi.bootcamp.backenddesafio.dtos.ProdutoDto
import com.tqi.bootcamp.backenddesafio.entities.Produto
import com.tqi.bootcamp.backenddesafio.repositories.ProdutoRepository
import org.springframework.stereotype.Service

@Service
class ProdutoService(private val repository: ProdutoRepository) {

    fun save(produto: ProdutoDto): Produto{
        println(produto.unidadeMedida)
        return this.repository.save(produto.toEntity())
    }

    fun buscar():Iterable<Produto> {
        return repository.findAll()
    }
}