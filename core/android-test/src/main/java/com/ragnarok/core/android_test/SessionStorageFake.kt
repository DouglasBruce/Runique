package com.ragnarok.core.android_test

import com.ragnarok.core.domain.AuthInfo
import com.ragnarok.core.domain.SessionStorage

class SessionStorageFake: SessionStorage {

    private var authInfo: AuthInfo? = null

    override suspend fun get(): AuthInfo? {
        return authInfo
    }

    override suspend fun set(info: AuthInfo?) {
        authInfo = info
    }
}