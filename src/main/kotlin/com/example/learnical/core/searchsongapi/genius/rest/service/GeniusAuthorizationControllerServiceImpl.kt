package com.example.learnical.core.searchsongapi.genius.rest.service

import com.example.learnical.core.searchsongapi.genius.rest.controller.GeniusAuthorizationController
import com.example.learnical.core.user.User
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap


@Service
class GeniusAuthorizationControllerServiceImpl : GeniusAuthorizationControllerService {
    // TODO this methods needs to interact with the persistence layer. currently using an in memory map and assumes there is only a one user on the system
    val mapTokens = HashMap<User, GeniusAuthorizationController.GeniusJWT>()

    override fun storeAuthorizationToken(user: User, jwtToken: GeniusAuthorizationController.GeniusJWT) {
        mapTokens.put(user, jwtToken)
    }

    override fun retrieveAuthorizationToken(user: User): GeniusAuthorizationController.GeniusJWT? = mapTokens.get(user)
}