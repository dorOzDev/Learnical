package com.example.learnical.core.searchsongapi.genius.rest.service

import com.example.learnical.core.searchsongapi.AuthorizationStore
import com.example.learnical.core.searchsongapi.genius.model.GeniusJWT
import com.example.learnical.core.user.User
import org.springframework.stereotype.Service


@Service

class GeniusAuthorizationControllerServiceImpl(val geniusAuthStore : AuthorizationStore<GeniusJWT>) : GeniusAuthorizationControllerService {

    override fun storeAuthorizationToken(user: User, jwtToken: GeniusJWT) {
        geniusAuthStore.storeAuthorizationToken(user, jwtToken)
    }

    override fun retrieveAuthorizationToken(user: User): GeniusJWT? = geniusAuthStore.retrieveAuthorizationToken(user)
}