package com.example.learnical.core.process

import com.example.learnical.core.persistence.jap.JapaneseTokenWrapper

interface LyricProcessor {

    /**
     * converts a lyric in it's native language and returns a list of token
     * */
    fun processLyrics(lyric: String) : List<JapaneseTokenWrapper>
}