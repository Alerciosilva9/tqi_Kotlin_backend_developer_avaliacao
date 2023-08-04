package com.tqi.bootcamp.backenddesafio

import com.fasterxml.jackson.databind.ObjectMapper
import com.tqi.bootcamp.backenddesafio.dtos.ProdutoDto
import com.tqi.bootcamp.backenddesafio.entities.Categoria
import com.tqi.bootcamp.backenddesafio.enums.UnidadeMedida
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.math.BigDecimal

@SpringBootTest
@AutoConfigureMockMvc
class ProdutoControllerTest {

    @Autowired
    lateinit var mockm: MockMvc

    @Test
    fun `buscar todos os produtos`(){
        mockm.perform(MockMvcRequestBuilders.get("/produto")).andExpect(MockMvcResultMatchers.status().isOk).andDo(
            MockMvcResultHandlers.print())
    }


    @Test
    fun `cadastro produtos`(){
        val novo = ProdutoDto(nome="Coca Cola", unidadeMedida= UnidadeMedida.LITRO,precoUnitario=1.22.toBigDecimal(),idCategoria=1)
        val json = ObjectMapper().writeValueAsString(novo)
        mockm.perform(
            MockMvcRequestBuilders.post("/produto").accept(MediaType.APPLICATION_JSON).
        contentType(MediaType.APPLICATION_JSON).content(json))
            .andExpect(MockMvcResultMatchers.status().isOk).andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.jsonPath("$.nome" ).value("Coca Cola"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.precoUnitario" ).value(1.22))
    }
}