package com.example.learnical.jap.rest.service

import com.example.learnical.core.common.logger
import com.example.learnical.jap.model.JapaneseTokenWrapper
import com.example.learnical.jap.processor.JapaneseLyricsProcessor
import com.example.learnical.core.searchsongapi.SearchSongsApi
import com.example.learnical.core.searchsongapi.WebScrapper
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class JapaneseRomajiControllerServiceImpl(val lyricProcessor: JapaneseLyricsProcessor, val webScrapper: WebScrapper, val searchSongApi : SearchSongsApi) :
    JapaneseRomajiControllerService {

    val LOGGER by logger()

    override fun convertToRomaji(lyric: String): String {
        val processLyrics = lyricProcessor.processLyrics(lyric)
        val sb = StringBuilder()
        processLyrics.forEach{tokenWrapper ->
            if(tokenWrapper is JapaneseTokenWrapper) {
                sb.append(tokenWrapper.getReading())
            } else {
                sb.append(tokenWrapper.token.surface)
            }
        }

        return sb.toString()
    }

    override fun searchSongToRomaji(songName: String): Pair<Boolean, String> {
        LOGGER.info("search for song: $songName")
        val searchSongLyricLink = searchSongApi.searchSongLyricLink(songName)

        return if(searchSongLyricLink == null) {
            LOGGER.info(String.format("couldn't find a song with name: %s", songName))
            RomajiControllerService.Constant.SONG_NOT_FOUND_PAIR
        } else {
            val document = Jsoup.connect(searchSongLyricLink.getLyricResult())
                .userAgent("chrome")
                .get()
            return Pair(true, webScrapper.scrapRelatedSong(document))
        }
    }
}