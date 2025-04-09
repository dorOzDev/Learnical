package com.example.learnical.core.searchsongapi

import com.example.learnical.core.user.User

interface AuthorizationStore<TOKEN : AuthorizationToken> {

    /**
     * store a JWT token for the given user.
     * */
    fun storeAuthorizationToken(user: User, token :TOKEN)

    /**
     * return current stored jwt token for the given user.
     * return null if non token is currently stored
     * */
    fun retrieveAuthorizationToken(user : User) : TOKEN?
}