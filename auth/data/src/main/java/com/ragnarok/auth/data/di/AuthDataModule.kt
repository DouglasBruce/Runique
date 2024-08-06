package com.ragnarok.auth.data.di

import com.ragnarok.auth.data.EmailPatternValidator
import com.ragnarok.auth.data.AuthRepositoryImpl
import com.ragnarok.auth.domain.AuthRepository
import com.ragnarok.auth.domain.PatternValidator
import com.ragnarok.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}