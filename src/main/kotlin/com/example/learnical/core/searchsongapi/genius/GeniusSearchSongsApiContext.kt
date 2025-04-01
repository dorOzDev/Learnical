package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.searchsongapi.SearchSongsApiContext
import com.example.learnical.core.searchsongapi.WebScrapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GeniusSearchSongsApiContext : SearchSongsApiContext {

    @Bean
    override fun provideWebScrapper(): WebScrapper = GeniusWebScrapper()
}