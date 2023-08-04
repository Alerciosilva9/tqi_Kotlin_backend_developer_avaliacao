package com.tqi.bootcamp.backenddesafio

import com.fasterxml.jackson.databind.ObjectMapper
import com.tqi.bootcamp.backenddesafio.entities.Categoria
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
class CategoriaControllerTest {

    @Autowired
    lateinit var mock: MockMvc

    @Test
    fun `buscar todas as categorias`(){
        mock.perform(MockMvcRequestBuilders.get("/categoria")).andExpect(MockMvcResultMatchers.status().isOk).andDo(MockMvcResultHandlers.print())
    }




}