package com.example.learnical.core.persistence.model

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