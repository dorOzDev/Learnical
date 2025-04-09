package com.example.learnical.core.searchsongapi.genius

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class GeniusHitResult(@JsonProperty(value = "api_path") val apiPath : String, val url : String) {

}
@JsonIgnoreProperties(ignoreUnknown = true)
data class GeniusHit(@JsonProperty("result") val hitResult: GeniusHitResult) {

}