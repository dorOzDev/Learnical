package com.example.learnical.core.rest.service

import com.example.learnical.core.persistence.jap.JapaneseTokenWrapperImpl
import com.example.learnical.core.process.LyricProcessor
import org.springframework.stereotype.Service

@Service
class RomajiControllerServiceImpl(val lyricProcessor: LyricProcessor) : JapaneaseRomajiControllerService {

    override fun convertToRomaji(lyric: String): String {
        val processLyrics = lyricProcessor.processLyrics(lyric)
        val sb = StringBuilder()
        processLyrics.forEach{tokenWrapper ->
            if(tokenWrapper is JapaneseTokenWrapperImpl) {
                sb.append(tokenWrapper.getReading())
            } else {
                sb.append(tokenWrapper.token.surface)
            }
        }

        return sb.toString()
    }

    override fun searchSongToRomaji(lyricName: String): String {
        TODO("Not yet implemented")
    }
}