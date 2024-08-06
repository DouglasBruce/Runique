package com.ragnarok.auth.presentation.di

import com.ragnarok.auth.presentation.login.LoginViewModel
import com.ragnarok.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}