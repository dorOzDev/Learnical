package com.example.learnical.core.converter

import com.atilika.kuromoji.ipadic.Token
import fr.free.nrw.jakaroma.KanaToRomaji
import org.springframework.stereotype.Service

@Service
class RomajiConverterImpl : RomajiConverter {

    val kanaToRomaji = KanaToRomaji()

    override fun getRomajiReading(token: Token): String = kanaToRomaji.convert(token.reading)
}