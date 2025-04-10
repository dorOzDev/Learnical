package com.example.learnical.core.process

import com.example.learnical.core.persistence.model.TokenWrapper

interface LyricProcessor<T> {

    /**
     * converts a lyric in it's native language and returns a list of token
     * */
    fun processLyrics(lyric: String) : List<TokenWrapper<T>>
}