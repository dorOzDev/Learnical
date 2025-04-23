package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.common.logger
import com.example.learnical.core.searchsongapi.WebScrapper
import org.jsoup.nodes.Document

class GeniusWebScrapper : WebScrapper {

    val logger by logger()

    override fun scrapRelatedSong(document: Document): String {
        logger.info("scrapping a document")
        val select = document.select("div[data-lyrics-container=true]")
        val sb = StringBuilder()
        select.forEach {elem ->
            val textNodes = elem.textNodes()
            textNodes.forEach{textNode ->
                sb.append(textNode.text())
                sb.append("\n")
            }
            sb.append("\n")
        }
        return sb.toString()
    }
}