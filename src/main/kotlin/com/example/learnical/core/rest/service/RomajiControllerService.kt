package com.example.learnical.core.rest.service

import java.lang.RuntimeException
import kotlin.jvm.Throws

interface RomajiControllerService {

    /**
     * takes a lyrics in native language and covnerts it to a romanized english version
     * */
    @Throws(RuntimeException::class)
    fun convertToRomaji(lyric : String) : String

    /**
     * serach for the lyric by the lyric name for any lyrics api site, and returns a romanized version out of it.
     * this api depends on credential for the given api site.
     * */
    @Throws(RuntimeException::class)
    fun searchSongToRomaji(lyricName : String) : String
}