package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.common.logger
import com.example.learnical.core.searchsongapi.AbstractSearchSongsApi
import com.example.learnical.core.searchsongapi.AuthorizationStore
import com.example.learnical.core.searchsongapi.genius.GeniusSearchSongsApi.GeniusApiUrl.ROMANIZED
import com.example.learnical.core.searchsongapi.genius.model.GeniusJWT
import com.example.learnical.core.user.UserService
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatusCode
import org.springframework.web.client.RestTemplate

class GeniusSearchSongsApi(restTemplate: RestTemplate, val geniusStore: AuthorizationStore<GeniusJWT>, val userService: UserService) : AbstractSearchSongsApi(restTemplate) {

    val LOGGER by logger()

    override fun searchSongLyricLink(songName: String): SearchSongResult? {
        val headers : HttpHeaders = createHeaders()
        val entity = HttpEntity("", headers)
        val wellFormattedSongName = if (songName.contains(ROMANIZED)) songName else songName.plus(" $ROMANIZED")
        val url = String.format(GeniusApiUrl.SEARCH_URL, wellFormattedSongName)
        val exchange = restTemplate.exchange(url, HttpMethod.GET, entity, GeniusSearchSongResult::class.java)

        if(exchange.statusCode == HttpStatusCode.valueOf(200)) {
            val body = exchange.body
            return body
        }

        return null
    }

    private fun createHeaders(): HttpHeaders {
        val headers = HttpHeaders()
        val user = userService.getLoggedInUser()
        val state = checkNotNull(geniusStore.retrieveAuthorizationToken(user)) {"no bearer token was found to user: ${user.uuid}"}
        headers.setBearerAuth(state.accessToken)

        return headers
    }

    private object GeniusApiUrl {
        const val SEARCH_URL = "https://api.genius.com/search?q=%s"
        const val ROMANIZED = "romannized";
    }
}