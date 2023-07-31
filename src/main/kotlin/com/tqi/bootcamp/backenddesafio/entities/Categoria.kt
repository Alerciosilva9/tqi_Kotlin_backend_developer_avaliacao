package com.tqi.bootcamp.backenddesafio.entities

import jakarta.persistence.*

@Entity
data class Categoria(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
        var nome: String)