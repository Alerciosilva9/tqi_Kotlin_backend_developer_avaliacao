package com.tqi.bootcamp.backenddesafio.dtos

import com.tqi.bootcamp.backenddesafio.entities.Categoria
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CategoriaDto(
        @field:NotBlank(message = "Invalid input")
        @field:Size(max = 40)
        val nome: String
){
    fun toEntity(): Categoria = Categoria(
            nome = this.nome
    )
}
