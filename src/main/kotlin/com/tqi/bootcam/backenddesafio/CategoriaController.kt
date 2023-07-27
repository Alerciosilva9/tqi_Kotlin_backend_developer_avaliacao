package com.tqi.bootcam.backenddesafio

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class CategoriaController {

    @GetMapping
    fun helloworld():String{
        return "Olá mundo";
    }

}