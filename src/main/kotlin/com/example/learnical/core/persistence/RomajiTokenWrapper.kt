package com.example.learnical.core.persistence

import ch.qos.logback.core.subst.Tokenizer
import com.atilika.kuromoji.ipadic.Token
import org.apache.commons.lang3.StringUtils


data class RomajiTokenWrapper(
    override val token: Token,
    private val _romajiReading: String) : TokenWrapper {
        val romajiReading : String
            get() {
                return if(_romajiReading.endsWith(" ")) _romajiReading  else _romajiReading + " "
            }
    }


