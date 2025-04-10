package com.example.learnical.jap.processor

import com.atilika.kuromoji.ipadic.Token
import com.atilika.kuromoji.ipadic.Tokenizer
import com.example.learnical.core.common.logger
import com.example.learnical.jap.converter.RomajiConverter
import com.example.learnical.core.persistence.model.TokenWrapper
import com.example.learnical.core.persistence.model.UnknownTokenWrapper
import com.example.learnical.jap.model.JapaneseTokenWrapper
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class JapaneseLyricsProcessorImpl(val romajiConverter : RomajiConverter) : JapaneseLyricsProcessor {

    val LOGGER by logger()
    val tokenizer = Tokenizer()

    override fun processLyrics(lyric: String): List<TokenWrapper<Token>> {
        Assert.notNull(lyric, "lyric cannot be null")
        val tokens = tokenizer.tokenize(lyric)
        val tokenList = mutableListOf<TokenWrapper<Token>>()
        tokens.forEach { token ->
            if (token.isKnown) {
                val romajiReading = romajiConverter.getRomajiReading(token)
                if(romajiReading == null) {
                    LOGGER.debug("unable to find romaji reading for kana: ${token.reading}")
                } else {
                    tokenList.add(JapaneseTokenWrapper(token, romajiReading))
                }
            } else {
                tokenList.add(UnknownTokenWrapper(token))
            }
        }

        return tokenList
    }
}