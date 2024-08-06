package com.ragnarok.run.presentation.di

import com.ragnarok.run.domain.RunningTracker
import com.ragnarok.run.presentation.active.ActiveRunViewModel
import com.ragnarok.run.presentation.overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}