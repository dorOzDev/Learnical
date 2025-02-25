package com.example.learnical.core.persistence

import ch.qos.logback.core.subst.Tokenizer
import com.atilika.kuromoji.ipadic.Token


data class RomajiTokenWrapper(
    override val token: Token,
    val romajiReading: String) : TokenWrapper



