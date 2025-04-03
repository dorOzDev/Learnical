package com.example.learnical.core.searchsongapi

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.client.RestTemplate

/**
 * this interface defines all the needed beans in order to have an integration with the Search Lyrics song provider and how to
 * scrap the lyric property out of that api
 *
 * */
interface SearchSongsApiContext {

    /**
     * a scrapper to property scrap the web
     * */
    fun webScrapper() : WebScrapper

    /**
     * a middleware between the lyric provider and the needs of the user.
     * */
    fun searchSongsApi(restTemplate : RestTemplate) : SearchSongsApi

    /**
     * define the way to connect with the third part lyric provider.
     * */
    fun restTemplate(builder : RestTemplateBuilder) : RestTemplate
}