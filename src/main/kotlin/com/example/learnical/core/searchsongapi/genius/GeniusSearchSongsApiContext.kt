package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.searchsongapi.AuthorizationStore
import com.example.learnical.core.searchsongapi.SearchSongsApi
import com.example.learnical.core.searchsongapi.SearchSongsApiContext
import com.example.learnical.core.searchsongapi.WebScrapper
import com.example.learnical.core.searchsongapi.genius.model.GeniusJWT
import com.example.learnical.core.searchsongapi.genius.store.GeniusAuthorizationStoreImpl
import com.example.learnical.core.user.UserService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class GeniusSearchSongsApiContext : SearchSongsApiContext<GeniusJWT> {

    @Bean
    override fun webScrapper(): WebScrapper = GeniusWebScrapper()

    @Bean
    override fun searchSongsApi(
        restTemplate: RestTemplate,
        authorizationStore: AuthorizationStore<GeniusJWT>,
        userService: UserService): SearchSongsApi = GeniusSearchSongsApi(restTemplate, authorizationStore, userService)

    @Bean
    override fun restTemplate(builder : RestTemplateBuilder): RestTemplate {
        return RestTemplate()
    }

    @Bean
    override fun authStore() : AuthorizationStore<GeniusJWT> = GeniusAuthorizationStoreImpl()
}