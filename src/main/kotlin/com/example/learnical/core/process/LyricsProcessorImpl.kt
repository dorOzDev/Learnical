package com.example.learnical.core.process

import com.atilika.kuromoji.ipadic.Tokenizer
import com.example.learnical.core.common.logger
import com.example.learnical.core.persistence.RomajiTokenWrapper
import com.example.learnical.core.persistence.TokenWrapper
import com.example.learnical.core.persistence.UnknownTokenWrapper
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class LyricsProcessorImpl :LyricProcessor {

    val LOGGER by logger()
    val tokenizer = Tokenizer()

    override fun processLyrics(lyric: String): List<TokenWrapper> {
        Assert.notNull(lyric, "lyric cannot be null")
        val tokens = tokenizer.tokenize(lyric)
        val tokenList = mutableListOf<TokenWrapper>()
        tokens.forEach { token ->
            if (token.isKnown) {
                tokenList.add(RomajiTokenWrapper(token, "someRomajiReading"))
            } else {
                tokenList.add(UnknownTokenWrapper(token))
            }
        }

        return tokenList
    }
}