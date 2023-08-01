package com.tqi.bootcamp.backenddesafio.controllers

import com.tqi.bootcamp.backenddesafio.dtos.Pagamento
import com.tqi.bootcamp.backenddesafio.enums.FormaPagamento
import com.tqi.bootcamp.backenddesafio.services.CarrinhoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/finalizar")
class VendaController(private val service:CarrinhoService) {
    @GetMapping
    fun verCarrinho():ResponseEntity<String>{

        return ResponseEntity.ok().body("Total Compra: ".plus(this.service.getTotalCarrinho())
            .plus("\n\nItens no carrinho:\n").plus(this.service.getAll().toString())
                                            )
    }

    @PostMapping
    fun finalizar(@RequestBody pagamento: Pagamento):ResponseEntity<String>{
        val total = this.service.getTotalCarrinho()
        if(total <= BigDecimal.ZERO){
            return ResponseEntity.badRequest().body("Sem itens no carrinho")
        }

        val contains: Boolean =
            try {
               FormaPagamento.valueOf(pagamento.forma)
                true
            } catch (e: IllegalArgumentException) {
                false
            }
        if(contains){
            return ResponseEntity.ok().body("Compra realizada com Sucesso, debitado ".plus(total).plus(" por meio de ")
                .plus(pagamento.forma)
            )
        }

        return ResponseEntity.badRequest().body("Informe uma forma de pagamento valida")


    }


}