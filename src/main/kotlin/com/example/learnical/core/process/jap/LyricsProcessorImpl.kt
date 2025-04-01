package com.example.learnical.core.process.jap

import com.atilika.kuromoji.ipadic.Tokenizer
import com.example.learnical.core.common.logger
import com.example.learnical.core.converter.RomajiConverter
import com.example.learnical.core.persistence.UnknownTokenWrapper
import com.example.learnical.core.persistence.jap.JapaneseTokenWrapperImpl
import com.example.learnical.core.process.LyricProcessor
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class LyricsProcessorImpl(val romajiConverter : RomajiConverter) : LyricProcessor {

    val LOGGER by logger()
    val tokenizer = Tokenizer()

    override fun processLyrics(lyric: String): List<com.example.learnical.core.persistence.jap.JapaneseTokenWrapper> {
        Assert.notNull(lyric, "lyric cannot be null")
        val tokens = tokenizer.tokenize(lyric)
        val tokenList = mutableListOf<com.example.learnical.core.persistence.jap.JapaneseTokenWrapper>()
        tokens.forEach { token ->
            if (token.isKnown) {
                val romajiReading = romajiConverter.getRomajiReading(token)
                if(romajiReading == null) {
                    LOGGER.debug("unable to find romaji reading for kana: ${token.reading}")
                } else {
                    tokenList.add(JapaneseTokenWrapperImpl(token, romajiReading))
                }
            } else {
                tokenList.add(UnknownTokenWrapper(token))
            }
        }

        return tokenList
    }
}