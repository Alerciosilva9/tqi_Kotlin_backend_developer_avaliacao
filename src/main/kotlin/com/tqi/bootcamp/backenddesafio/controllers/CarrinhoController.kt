package com.tqi.bootcamp.backenddesafio.controllers

import com.tqi.bootcamp.backenddesafio.dtos.ProdutoCarrinhoDto
import com.tqi.bootcamp.backenddesafio.services.CarrinhoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/carrinho")
class CarrinhoController(private val carrinho:CarrinhoService){

    @GetMapping
    fun getAll():List<ProdutoCarrinhoDto>{
        println(this.carrinho.getTotalCarrinho())
        return this.carrinho.getAll()
    }

    @PostMapping
    fun adicionar(@RequestBody @Validated prod:ProdutoCarrinhoDto):ResponseEntity<String>{
        if(this.carrinho.adicionar(prod))
            return ResponseEntity.ok().body("Produto adicionado ao carrinho")

        return ResponseEntity.badRequest().body("Informe Id e Quantidade Validos")
    }
}