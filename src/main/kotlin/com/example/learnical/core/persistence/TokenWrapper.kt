package com.example.learnical.core.persistence

interface TokenWrapper<T> {
    val token : T

    /**
     * return the original token
     * */
    fun getOriginToken() : T = token

    /**
     * returns the reading of the token
     * */
    fun getReading() : String

}