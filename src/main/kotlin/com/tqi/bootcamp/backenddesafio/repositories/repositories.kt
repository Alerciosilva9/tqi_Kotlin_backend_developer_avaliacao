package com.tqi.bootcamp.backenddesafio.repositories

import com.tqi.bootcamp.backenddesafio.entities.Categoria
import org.springframework.data.repository.CrudRepository



interface CategoriaRepository : CrudRepository<Categoria, Long> {

}