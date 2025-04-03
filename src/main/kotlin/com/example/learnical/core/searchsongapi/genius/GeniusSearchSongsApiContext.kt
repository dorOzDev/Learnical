package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.searchsongapi.SearchSongsApi
import com.example.learnical.core.searchsongapi.SearchSongsApiContext
import com.example.learnical.core.searchsongapi.WebScrapper
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class GeniusSearchSongsApiContext : SearchSongsApiContext {

    @Bean
    override fun webScrapper(): WebScrapper = GeniusWebScrapper()

    @Bean
    override fun searchSongsApi(restTemplate: RestTemplate): SearchSongsApi = GeniusSearchSongsApi(restTemplate)

    @Bean
    override fun restTemplate(builder : RestTemplateBuilder): RestTemplate {
        return RestTemplate()
    }
}