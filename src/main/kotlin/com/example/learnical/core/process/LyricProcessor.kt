package com.example.learnical.core.process

import com.example.learnical.core.persistence.TokenWrapper
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

interface LyricProcessor {

    fun processLyrics(lyric: String) : List<TokenWrapper>
}