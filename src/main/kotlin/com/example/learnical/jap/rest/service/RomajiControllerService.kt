package com.example.learnical.jap.rest.service

import com.example.learnical.core.searchsongapi.model.ConvertionToRomajiResult
import com.example.learnical.core.searchsongapi.model.SearchSongData
import com.example.learnical.core.searchsongapi.model.SongSearchResult
import java.lang.RuntimeException
import kotlin.jvm.Throws

interface RomajiControllerService {

    /**
     * takes a lyrics in native language and covnerts it to a romanized english version
     * */
    @Throws(RuntimeException::class)
    fun convertToRomaji(lyric : String) : ConvertionToRomajiResult

    /**
     * serach for the lyric by the lyric name for any lyrics api site.
     * @
     * @return SongSearchResult if the song was found and the song as a string.
     * this api depends on credential for the given api site.
     *
     * */
    @Throws(RuntimeException::class)
    fun searchSongToRomaji(songName : String) : SongSearchResult

    object Constant {
        val SONG_NOT_FOUND_PAIR = SongSearchResult(false, null)
    }
}