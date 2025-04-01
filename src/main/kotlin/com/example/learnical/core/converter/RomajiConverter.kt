package com.example.learnical.core.converter

import com.atilika.kuromoji.ipadic.Token

interface RomajiConverter {

    fun getRomajiReading(token : Token) : String?
}