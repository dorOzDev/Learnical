package com.example.learnical.jap.converter

import com.atilika.kuromoji.ipadic.Token
import com.github.jikyo.romaji.Transliterator
import org.springframework.stereotype.Service

@Service
class RomajiConverterImpl : RomajiConverter {


    override fun getRomajiReading(token: Token): String? {
        val transliterateList = Transliterator.transliterate(token.reading)
        return if (transliterateList.size > 0) transliterateList.get(0) else null
    }
}