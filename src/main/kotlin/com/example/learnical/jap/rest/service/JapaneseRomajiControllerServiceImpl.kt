package com.example.learnical.jap.rest.service

import com.example.learnical.core.common.logger
import com.example.learnical.jap.model.JapaneseTokenWrapper
import com.example.learnical.jap.processor.JapaneseLyricsProcessor
import com.example.learnical.core.searchsongapi.SearchSongsApi
import com.example.learnical.core.searchsongapi.WebScrapper
import com.example.learnical.core.searchsongapi.model.ConvertionToRomajiResult
import com.example.learnical.core.searchsongapi.model.SearchSongData
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class JapaneseRomajiControllerServiceImpl(val lyricProcessor: JapaneseLyricsProcessor, val webScrapper: WebScrapper, val searchSongApi : SearchSongsApi) :
    JapaneseRomajiControllerService {

    val logger by logger()

    override fun convertToRomaji(lyric: String): ConvertionToRomajiResult {
        val processLyrics = lyricProcessor.processLyrics(lyric)
        val sb = StringBuilder()
        processLyrics.forEach{tokenWrapper ->
            if(tokenWrapper is JapaneseTokenWrapper) {
                sb.append(tokenWrapper.getReading())
            } else {
                sb.append(tokenWrapper.token.surface)
            }
        }

        return ConvertionToRomajiResult(sb.toString())
    }

    override fun searchSongToRomaji(songName: String): Pair<Boolean, SearchSongData> {
        logger.info("search for song: $songName")
        val searchSongLyricLink = searchSongApi.searchSongLyricLink(songName)

        return if(searchSongLyricLink == null || searchSongLyricLink.getSongApiUrl() == null) {
            logger.info(String.format("couldn't find a song with name: %s", songName))
            RomajiControllerService.Constant.SONG_NOT_FOUND_PAIR
        } else {
            logger.info("getting html page for song $songName, from link ${searchSongLyricLink.getSongApiUrl()}")
            val document = Jsoup.connect(searchSongLyricLink.getSongApiUrl()!!)
                .userAgent("Mozilla")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Accept", "text/html")
                .header("Connection", "keep-alive")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Cache-Control", "max-age=0")
                .referrer("https://www.google.com")
                .get()
            val second = SearchSongData(songName, searchSongLyricLink.getSongApiUrl()!!, webScrapper.scrapRelatedSong(document))
            Pair(true, second)
        }
    }
}