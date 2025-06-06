package com.example.learnical.core.searchsongapi.genius

import com.example.learnical.core.searchsongapi.model.SearchSongResult
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class GeniusSearchSongResult(@JsonProperty(value = "response") private val geniusSearchResult : GeniusSearchResultData) :
    SearchSongResult {

    override fun getSongApiUrl(): String? {
        return if(geniusSearchResult.hits.size > 0) {
            geniusSearchResult.hits[0].hitResult.url
        } else return null
    }
}