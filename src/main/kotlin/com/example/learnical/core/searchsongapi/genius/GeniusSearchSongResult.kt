package com.example.learnical.core.searchsongapi.genius

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class GeniusSearchSongResult(private val geniusSearchResult : GeniusSearchResultData) : SearchSongResult {

    override fun getLyricResult(): String {
        return geniusSearchResult.hits[0].url
    }
}