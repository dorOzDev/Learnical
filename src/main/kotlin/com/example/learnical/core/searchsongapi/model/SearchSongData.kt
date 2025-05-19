package com.example.learnical.core.searchsongapi.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class SearchSongData @JsonCreator constructor(
    @JsonProperty("songName") val songName: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("lyric") val lyric: String)
