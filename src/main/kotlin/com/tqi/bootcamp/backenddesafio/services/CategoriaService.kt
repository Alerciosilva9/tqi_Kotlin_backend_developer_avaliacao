package com.tqi.bootcamp.backenddesafio.services

import com.tqi.bootcamp.backenddesafio.dtos.CategoriaDto
import com.tqi.bootcamp.backenddesafio.entities.Categoria
import com.tqi.bootcamp.backenddesafio.repositories.CategoriaRepository
import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
class CategoriaService(
        private val repository: CategoriaRepository) {
    fun save(categoria: CategoriaDto): Categoria {

        return this.repository.save(categoria.toEntity())
    }

    fun buscar():Iterable<Categoria> {
        return repository.findAll()
    }
}