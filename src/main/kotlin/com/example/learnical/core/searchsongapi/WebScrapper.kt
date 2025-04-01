package com.example.learnical.core.searchsongapi

import org.jsoup.nodes.Document

interface WebScrapper {

    /**
     * takes a document and scrap the song content
     * */
    fun scrapRelatedSong(document: Document) : String
}