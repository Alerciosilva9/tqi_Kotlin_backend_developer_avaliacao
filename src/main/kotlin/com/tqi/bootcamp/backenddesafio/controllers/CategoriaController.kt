package com.tqi.bootcamp.backenddesafio.controllers


import com.tqi.bootcamp.backenddesafio.dtos.CategoriaDto
import com.tqi.bootcamp.backenddesafio.entities.Categoria
import com.tqi.bootcamp.backenddesafio.services.CategoriaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/categoria")
class CategoriaController(private val service: CategoriaService) {
    @GetMapping
    fun buscartodos():Iterable<Categoria> {
        return service.buscar()
    }

    @PostMapping
    fun cadastrar(@Valid @RequestBody categoria: CategoriaDto):ResponseEntity<String> {
        return try {
            ResponseEntity.ok(service.save(categoria).toString())
        }catch(e: Exception){
            ResponseEntity.badRequest().body(e.message)
        }
    }
}