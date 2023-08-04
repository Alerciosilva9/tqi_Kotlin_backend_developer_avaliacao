package com.tqi.bootcamp.backenddesafio.services

import com.tqi.bootcamp.backenddesafio.dtos.ProdutoCarrinhoDto
import com.tqi.bootcamp.backenddesafio.dtos.ProdutoDto
import com.tqi.bootcamp.backenddesafio.entities.Produto
import com.tqi.bootcamp.backenddesafio.repositories.ProdutoRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.Optional


@Service
class CarrinhoService(private val produtos: MutableList<ProdutoCarrinhoDto>,private val prodRepository:ProdutoRepository) {


    fun adicionar(prod:ProdutoCarrinhoDto):Boolean{
        if(prod.idProduto > 0 && prod.quantidade>0){
            val produto:Optional<Produto> = prodRepository.findById(prod.idProduto)
            if(produto.isPresent){
                val produtoEncontrado:Produto = produto.get()
                prod.precoTotalItem = BigDecimal.valueOf(prod.quantidade) * produtoEncontrado.precoUnitario
                return this.produtos.add(prod)
            }
            return false
        }
        return false

    }

    fun limpar():Boolean{
        this.produtos.clear()
        return true
    }

    fun getAll():List<ProdutoCarrinhoDto>{
        return this.produtos
    }

    fun getTotalCarrinho():BigDecimal{
        val total  = this.produtos.sumOf { it.precoTotalItem }
        return total
    }
}