package com.example.learnical.jap.converter

import com.atilika.kuromoji.ipadic.Token

interface RomajiConverter {

    fun getRomajiReading(token : Token) : String?
}