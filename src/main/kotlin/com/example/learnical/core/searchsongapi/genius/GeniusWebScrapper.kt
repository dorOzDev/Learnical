package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.common.logger
import com.example.learnical.core.searchsongapi.WebScrapper
import org.jsoup.nodes.Document

class GeniusWebScrapper : WebScrapper {

    val logger by logger()

    override fun scrapRelatedSong(doc: Document): String {
        logger.info("scrapping a document")
        val lyricsContainers = doc.select("div[data-lyrics-container=true]")

        val fullLyrics = lyricsContainers.joinToString("\n") { it.wholeText() }

        return if (fullLyrics.contains("[Intro]")) {
            fullLyrics.substring(fullLyrics.indexOf("[Intro]")).trim()
        } else {
            fullLyrics.trim()
        }
    }
}