package com.example.learnical.core.searchsongapi.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class SongSearchResult @JsonCreator constructor (
    @JsonProperty("found") val found: Boolean,
    @JsonProperty("data") val data: SearchSongData?)
