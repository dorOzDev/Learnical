package com.example.learnical.spotify

import jakarta.annotation.Nullable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SpotifyConnectorController {

    @GetMapping("/callback")
    // TODO add exchange code for a token
    fun searchRomajiLyrics(@RequestParam(name = "code") code : String, @RequestParam(name = "state") @Nullable state : String?) {

    }
}