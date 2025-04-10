package com.example.learnical.core.persistence.model

import java.lang.RuntimeException

data class UnknownTokenWrapper<T>(override val token: T) :
    TokenWrapper<T> {
    override fun getReading(): String {
        throw RuntimeException("no reading available, this token is unknown")
    }
}
