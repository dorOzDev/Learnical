package com.example.learnical.core.persistence

import com.atilika.kuromoji.ipadic.Token

data class UnknownTokenWrapper(override val token: Token) : TokenWrapper
