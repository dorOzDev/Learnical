package com.example.learnical.core.rest.service

import com.example.learnical.core.common.logger
import com.example.learnical.core.persistence.jap.JapaneseTokenWrapperImpl
import com.example.learnical.core.process.LyricProcessor
import com.example.learnical.core.searchsongapi.SearchSongsApi
import com.example.learnical.core.searchsongapi.WebScrapper
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class JapaneseRomajiControllerServiceImpl(val lyricProcessor: LyricProcessor, val webScrapper: WebScrapper, val searchSongApi : SearchSongsApi) : JapaneseRomajiControllerService {

    val LOGGER by logger()

    override fun convertToRomaji(lyric: String): String {
        val processLyrics = lyricProcessor.processLyrics(lyric)
        val sb = StringBuilder()
        processLyrics.forEach{tokenWrapper ->
            if(tokenWrapper is JapaneseTokenWrapperImpl) {
                sb.append(tokenWrapper.getReading())
            } else {
                sb.append(tokenWrapper.token.surface)
            }
        }

        return sb.toString()
    }

    override fun searchSongToRomaji(lyricName: String): String {
        LOGGER.info("search for song: $lyricName")
        val searchSongLyricLink = searchSongApi.searchSongLyricLink(lyricName)
        val document = Jsoup.connect("https://genius.com/Genius-romanizations-yuzu-hyori-ittai-romanized-lyrics")
            .userAgent("chrome")
            .get()
        return webScrapper.scrapRelatedSong(document)
    }
}