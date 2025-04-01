package com.example.learnical.core.persistence

import com.atilika.kuromoji.ipadic.Token
import com.example.learnical.core.persistence.jap.JapaneseTokenWrapper
import java.lang.RuntimeException

data class UnknownTokenWrapper(override val token: Token) :
    JapaneseTokenWrapper {
    override fun getReading(): String {
        throw RuntimeException("no reading available, this token is unknown")
    }
}
