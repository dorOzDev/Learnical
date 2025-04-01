package com.example.learnical.core.persistence.jap

import com.atilika.kuromoji.ipadic.Token


data class JapaneseTokenWrapperImpl(
    override val token: Token,
    private val _romajiReading: String) :
    JapaneseTokenWrapper {

    override fun getReading(): String {
        return if(_romajiReading.endsWith(" ")) _romajiReading  else _romajiReading + " "
    }
}


