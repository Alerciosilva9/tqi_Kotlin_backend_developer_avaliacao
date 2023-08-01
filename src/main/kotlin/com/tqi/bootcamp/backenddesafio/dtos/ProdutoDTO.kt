package com.tqi.bootcamp.backenddesafio.dtos

import com.tqi.bootcamp.backenddesafio.entities.Categoria
import com.tqi.bootcamp.backenddesafio.entities.Produto
import com.tqi.bootcamp.backenddesafio.enums.FormaPagamento
import com.tqi.bootcamp.backenddesafio.enums.UnidadeMedida
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal


data class ProdutoDto(
    @field:NotBlank(message = "Insira o nome do produto")
    @field:Size(max = 40)
    val nome: String,
    val unidadeMedida: UnidadeMedida,
    val precoUnitario: BigDecimal,
    val idCategoria: Long
){
    fun toEntity(): Produto = Produto(
        nome = this.nome,
        categoria = Categoria(this.idCategoria,""),
        unidadeDeMedida = this.unidadeMedida,
        precoUnitario = this.precoUnitario
    )
}

data class ProdutoCarrinhoDto(
    @field:NotNull() val idProduto:Long,
    @field:NotNull() val quantidade: Long,
    var precoTotalItem: BigDecimal = BigDecimal.ZERO
){


}

data class Pagamento(
    @field:NotNull(message = "Informe a forma de pagamento") val forma: String,
){


}