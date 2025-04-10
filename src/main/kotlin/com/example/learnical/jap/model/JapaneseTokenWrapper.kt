package com.example.learnical.jap.model

import com.atilika.kuromoji.ipadic.Token
import com.example.learnical.core.persistence.model.TokenWrapper


data class JapaneseTokenWrapper(
    override val token: Token,
    private val _romajiReading: String) :
    TokenWrapper<Token> {

    override fun getReading(): String {
        return if(_romajiReading.endsWith(" ")) _romajiReading  else _romajiReading + " "
    }
}


