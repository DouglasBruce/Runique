package com.ragnarok.run.location.di

import com.ragnarok.run.domain.LocationObserver
import com.ragnarok.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}