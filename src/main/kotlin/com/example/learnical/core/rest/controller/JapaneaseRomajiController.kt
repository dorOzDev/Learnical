package com.example.learnical.core.rest.controller

import com.example.learnical.core.common.logger
import com.example.learnical.core.rest.service.JapaneaseRomajiControllerService
import org.jsoup.Jsoup
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/jap")
class JapaneaseRomajiController(val controllerService : JapaneaseRomajiControllerService) {

    val LOGGER by logger()

    @GetMapping("/search")
    fun searchRomajiLyrics(@RequestParam(name = "song_name") songName : String) : ResponseEntity<out Any> {
            LOGGER.info("search for song: $songName")
            try {
            val connect = Jsoup.connect("https://genius.com/Genius-romanizations-yuzu-hyori-ittai-romanized-lyrics")
                .userAgent("chrome")
                .get()

            val select = connect.select("div.Lyrics__Container-sc-e3d9a1f6-1.jnkcum")
            val sb = StringBuilder()

            select.forEach {elem ->
                val textNodes = elem.textNodes()
                textNodes.forEach{textNode ->
                    sb.append(textNode.text())
                    sb.append("\n")
                }
                sb.append("\n")
            }
            return ResponseEntity.ok(sb.toString())

        } catch (e : Exception) {
            return ResponseEntity.internalServerError().build<Void>()
        }
    }


    @PostMapping("/romajiiconverter")
    fun convertToRomaji(@RequestBody body: String) : ResponseEntity<out Any> {
        LOGGER.info("converting to romaji")
        try {
            return ResponseEntity.ok(controllerService.convertToRomaji(body))
        } catch (e : Exception) {
         LOGGER.error("something went wrong with conversion: ${e.message}")
         return ResponseEntity.internalServerError().build<Void>()
        }
    }
}