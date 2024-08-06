package com.ragnarok.runique

import android.app.Application
import com.ragnarok.auth.data.di.authDataModule
import com.ragnarok.auth.presentation.di.authViewModelModule
import com.ragnarok.core.data.di.coreDataModule
import com.ragnarok.run.presentation.di.runViewModelModule
import com.ragnarok.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runViewModelModule
            )
        }
    }
}