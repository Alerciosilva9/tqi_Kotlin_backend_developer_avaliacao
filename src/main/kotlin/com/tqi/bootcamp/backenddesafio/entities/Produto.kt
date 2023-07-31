package com.tqi.bootcamp.backenddesafio.entities

import com.tqi.bootcamp.backenddesafio.enums.UnidadeMedida
import jakarta.persistence.*
import java.math.BigDecimal


@Entity
data class Produto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "nome_produto") val nome: String,
    @Enumerated(EnumType.STRING)
    @Column(name = "unidade_medida") val unidadeDeMedida: UnidadeMedida,
    @Column(name = "preco_unitario") val precoUnitario: BigDecimal,
    /*val quantidade: Int,*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    val categoria: Categoria
)