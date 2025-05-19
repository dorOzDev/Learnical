package com.example.learnical.core.searchsongapi

import com.example.learnical.core.searchsongapi.model.ApiSearchSongResult

interface SearchSongsApi {

    /**
     * search for link to the lyric of the song, returns null if not found.
     * */
    fun searchSongLyricLink(songName : String) : ApiSearchSongResult?
}