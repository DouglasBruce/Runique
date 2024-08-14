package com.ragnarok.run.network.di

import com.ragnarok.core.domain.run.RemoteRunDataSource
import com.ragnarok.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}