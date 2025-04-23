package com.example.learnical.jap.rest.controller

import com.example.learnical.core.common.logger
import com.example.learnical.jap.rest.service.JapaneseRomajiControllerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/jap")
class JapaneseRomajiController(val controllerService : JapaneseRomajiControllerService) {

    val logger by logger()

    @GetMapping("/search")
    fun searchRomajiLyrics(@RequestParam(name = "song_name") songName : String) : ResponseEntity<out Any> {
        logger.info("searching song: $songName")
        try {
            val res = controllerService.searchSongToRomaji(songName)
            return if(!res.first) {
                ResponseEntity.notFound().build()
            } else {
                ResponseEntity.ok(res.second)
            }
        } catch (e : Exception) {
            logger.error("something went wrong with searching for the song name: ${e.message}")
            return ResponseEntity.internalServerError().build<Void>()
        }
    }

    @PostMapping("/romajiiconverter")
    fun convertToRomaji(@RequestBody body: String) : ResponseEntity<out Any> {
        logger.info("converting to romaji")
        try {
            return ResponseEntity.ok(controllerService.convertToRomaji(body))
        } catch (e : Exception) {
         logger.error("something went wrong with conversion: ${e.message}")
         return ResponseEntity.internalServerError().build<Void>()
        }
    }
}