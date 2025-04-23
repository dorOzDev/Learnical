package com.example.learnical.core.searchsongapi.model

/**
 * this interface in charge of getting the data out of the api call result
 * */
interface SearchSongResult {

    /**
     * returns the url of the related song from the api call to the 3rd part api service
     * */
    fun getSongApiUrl() : String
}