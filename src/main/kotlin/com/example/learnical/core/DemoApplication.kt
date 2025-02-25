package com.example.learnical.core

import com.atilika.kuromoji.ipadic.Tokenizer
import com.moji4j.MojiConverter
import fr.free.nrw.jakaroma.KanaToRomaji
import org.apache.commons.lang3.StringUtils
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {

	runApplication<DemoApplication>(*args)
}
