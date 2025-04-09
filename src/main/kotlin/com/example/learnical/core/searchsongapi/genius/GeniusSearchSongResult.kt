package com.example.learnical.core.searchsongapi.genius

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class GeniusSearchSongResult(@JsonProperty(value = "response") private val geniusSearchResult : GeniusSearchResultData) : SearchSongResult {

    override fun getLyricResult(): String {
        return geniusSearchResult.hits[0].hitResult.url
    }
}