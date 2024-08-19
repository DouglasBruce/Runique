package com.ragnarok.wear.run.data.di

import com.ragnarok.wear.run.data.HealthServicesExerciseTracker
import com.ragnarok.wear.run.data.WatchToPhoneConnector
import com.ragnarok.wear.run.domain.ExerciseTracker
import com.ragnarok.wear.run.domain.PhoneConnector
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val wearRunDataModule = module {
    singleOf(::HealthServicesExerciseTracker).bind<ExerciseTracker>()
    singleOf(::WatchToPhoneConnector).bind<PhoneConnector>()
//    singleOf(::RunningTracker)
//    single {
//        get<RunningTracker>().elapsedTime
//    }
}