package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.searchsongapi.AbstractSearchSongsApi
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

class GeniusSearchSongsApi(restTemplate: RestTemplate) : AbstractSearchSongsApi(restTemplate) {

    override fun searchSongLyricLink(songName: String): SearchSongResult? {
        val headers = HttpHeaders()
        headers.setBearerAuth("x_VD7KS9fCStiaAeu7p4KfQpTFXzzdOS4felEzm9z38WJF8evgzSIhizw0z5kVx4")
        val entity = HttpEntity("", headers)
        val url = "https://api.genius.com/search?q=Hyori Ittai romanized"
        val exchange = restTemplate.exchange(url, HttpMethod.GET, entity, GeniusSearchSongResult::class.java)
        val body = exchange.body
        return body
    }
}