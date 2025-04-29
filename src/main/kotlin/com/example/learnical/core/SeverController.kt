package com.example.learnical.core

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SeverController {

    @GetMapping("/sanity")
    fun sanityCheck() : ResponseEntity<out Any> = ResponseEntity.ok().build()
}