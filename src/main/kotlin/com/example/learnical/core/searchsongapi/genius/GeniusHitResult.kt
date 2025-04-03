package com.example.learnical.core.searchsongapi.genius

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GeniusHitResult(val apiPath : String, val url : String) {
}