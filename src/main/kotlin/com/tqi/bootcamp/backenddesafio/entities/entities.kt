package com.tqi.bootcamp.backenddesafio.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy

@Entity
class Categoria(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
        @field:NotBlank(message = "Informe o nome da categoria") var nome: String)