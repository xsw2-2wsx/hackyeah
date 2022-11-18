package com.xsw22wsx.hackyeah

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {

    @GetMapping("/")
    fun helloWorld() = ResponseEntity.ok("Hello world! cicd test")

}