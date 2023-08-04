package com.tqi.bootcamp.backenddesafio.controllers

import com.tqi.bootcamp.backenddesafio.dtos.CategoriaDto
import com.tqi.bootcamp.backenddesafio.dtos.ProdutoDto
import com.tqi.bootcamp.backenddesafio.entities.Categoria
import com.tqi.bootcamp.backenddesafio.entities.Produto
import com.tqi.bootcamp.backenddesafio.repositories.ProdutoRepository
import com.tqi.bootcamp.backenddesafio.services.ProdutoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/produto")
class ProdutoController(private val service:ProdutoService ) {

    @PostMapping
    fun cadastrar(@Valid @RequestBody produto: ProdutoDto): ResponseEntity<Produto> {
        return try {
            ResponseEntity.status(HttpStatus.OK).body(service.save(produto))
        }catch(e: Exception){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
        }
    }

    @GetMapping
    fun buscarTodos():Iterable<Produto>{
        return service.buscar()
    }
}