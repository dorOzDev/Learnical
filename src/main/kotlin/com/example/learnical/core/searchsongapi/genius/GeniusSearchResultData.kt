package com.example.learnical.core.searchsongapi.genius

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GeniusSearchResultData(val hits : List<GeniusHitResult>) {
}