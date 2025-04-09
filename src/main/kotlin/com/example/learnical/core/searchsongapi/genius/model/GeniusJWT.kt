package com.example.learnical.core.searchsongapi.genius.model

import com.example.learnical.core.searchsongapi.AuthorizationToken

data class GeniusJWT(val accessToken : String,  val tokenType : String?) : AuthorizationToken {

    override fun getToken() = accessToken
}
