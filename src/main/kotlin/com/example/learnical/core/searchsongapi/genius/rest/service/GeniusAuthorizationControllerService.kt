package com.example.learnical.core.searchsongapi.genius.rest.service

import com.example.learnical.core.searchsongapi.genius.model.GeniusJWT
import com.example.learnical.core.searchsongapi.genius.rest.controller.GeniusAuthorizationController
import com.example.learnical.core.user.User


interface GeniusAuthorizationControllerService {

    /**
     * store a JWT token for the given user.
     * */
    fun storeAuthorizationToken(user: User, jwtToken : GeniusJWT)

    /**
     * return current stored jwt token for the given user.
     * return null if non token is currently stored
     * */
    fun retrieveAuthorizationToken(user : User) : GeniusJWT?
}