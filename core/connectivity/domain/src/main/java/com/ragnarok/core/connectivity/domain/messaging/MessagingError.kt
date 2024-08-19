package com.ragnarok.core.connectivity.domain.messaging

import com.ragnarok.core.domain.util.Error

enum class MessagingError : Error {
    CONNECTION_INTERRUPTED,
    DISCONNECTED,
    UNKNOWN
}