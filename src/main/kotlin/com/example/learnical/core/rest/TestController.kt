package com.example.learnical.core.rest

import com.example.learnical.core.persistence.RomajiTokenWrapper
import com.example.learnical.core.process.LyricProcessor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TestController(val lyricProcessor: LyricProcessor) {


    @PostMapping("/lyrics")
    fun getRomajiLyrics(@RequestBody body: String) : String {
        val processLyrics = lyricProcessor.processLyrics(body)
        val sb = StringBuilder()
        processLyrics.forEach{tokenWrapper ->
            if(tokenWrapper is RomajiTokenWrapper) {
                sb.append(tokenWrapper.romajiReading)
            } else {
                sb.append(tokenWrapper.token.surface)
            }
        }

        return sb.toString()
    }
}