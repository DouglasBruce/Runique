package com.ragnarok.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}