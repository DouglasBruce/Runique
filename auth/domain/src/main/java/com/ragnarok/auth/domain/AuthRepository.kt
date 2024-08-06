package com.ragnarok.auth.domain

import com.ragnarok.core.domain.util.DataError
import com.ragnarok.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}