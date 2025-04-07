package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.searchsongapi.AbstractSearchSongsApi
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatusCode
import org.springframework.web.client.RestTemplate

class GeniusSearchSongsApi(restTemplate: RestTemplate) : AbstractSearchSongsApi(restTemplate) {

    override fun searchSongLyricLink(songName: String): SearchSongResult? {
        val headers = HttpHeaders()
        headers.setBearerAuth("x_VD7KS9fCStiaAeu7p4KfQpTFXzzdOS4felEzm9z38WJF8evgzSIhizw0z5kVx4")
        val entity = HttpEntity("", headers)
        val wellFormattedSongName = if (songName.contains("romannized")) songName else songName.plus(" romannized")
        val url = String.format(GeniusApiUrl.SEARCH_URL, wellFormattedSongName)
        val exchange = restTemplate.exchange(url, HttpMethod.GET, entity, GeniusSearchSongResult::class.java)

        if(exchange.statusCode == HttpStatusCode.valueOf(200)) {
            val body = exchange.body
            return body
        }

        return null
    }

    private object GeniusApiUrl {
        const val SEARCH_URL = "https://api.genius.com/search?q=%s"
    }
}