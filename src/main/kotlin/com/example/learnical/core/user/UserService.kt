package com.example.learnical.core.user

import kotlin.jvm.Throws

interface UserService {
    /**
     * return the currently logged in user.
     * @throws NoUsedLoggedInException if no logged in user was found
     * */
    @Throws(NoUsedLoggedInException::class)
    fun getLoggedInUser() : User
}