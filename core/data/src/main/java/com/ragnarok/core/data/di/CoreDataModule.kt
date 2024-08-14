package com.ragnarok.core.data.di

import com.ragnarok.core.data.auth.EncryptedSessionStorage
import com.ragnarok.core.data.networking.HttpClientFactory
import com.ragnarok.core.data.run.OfflineFirstRunRepository
import com.ragnarok.core.domain.SessionStorage
import com.ragnarok.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}