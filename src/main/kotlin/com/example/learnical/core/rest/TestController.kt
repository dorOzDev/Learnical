package com.example.learnical.core.rest

import com.example.learnical.core.process.LyricProcessor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TestController(val lyricProcessor: LyricProcessor) {


    @PostMapping("/lyrics")
    fun getRomajiLyrics(@RequestBody body: String) {
        lyricProcessor.processLyrics(body)
    }
}