package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.searchsongapi.WebScrapper
import org.jsoup.nodes.Document

class GeniusWebScrapper : WebScrapper {

    override fun scrapRelatedSong(document: Document): String {
        val select = document.select("div.Lyrics__Container-sc-e3d9a1f6-1.jnkcum")
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