package com.example.learnical.core.searchsongapi

interface SearchSongsApiContext {

    fun provideWebScrapper() : WebScrapper
}