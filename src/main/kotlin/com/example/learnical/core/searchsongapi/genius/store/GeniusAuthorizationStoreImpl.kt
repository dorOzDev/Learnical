package com.example.learnical.core.searchsongapi.genius.store

import com.example.learnical.core.searchsongapi.AuthorizationStore
import com.example.learnical.core.searchsongapi.genius.model.GeniusJWT
import com.example.learnical.core.user.User

class GeniusAuthorizationStoreImpl : AuthorizationStore<GeniusJWT> {

    // TODO this methods needs to interact with the persistence layer. currently using an in memory map and assumes there is only a one user on the system
    private val mapTokens = HashMap<User, GeniusJWT>()

    override fun storeAuthorizationToken(user: User, token: GeniusJWT) {
        mapTokens[user] = token
    }

    override fun retrieveAuthorizationToken(user: User): GeniusJWT? = mapTokens[user]
}