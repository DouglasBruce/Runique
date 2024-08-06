package com.ragnarok.run.presentation.di

import com.ragnarok.run.presentation.active.ActiveRunViewModel
import com.ragnarok.run.presentation.overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}