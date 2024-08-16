package com.ragnarok.analytics.data.di

import com.ragnarok.analytics.data.RoomAnalyticsRepository
import com.ragnarok.analytics.domain.AnalyticsRepository
import com.ragnarok.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsDataModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}