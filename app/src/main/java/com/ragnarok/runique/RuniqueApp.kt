package com.ragnarok.runique

import android.app.Application
import com.ragnarok.auth.data.di.authDataModule
import com.ragnarok.auth.presentation.di.authViewModelModule
import com.ragnarok.core.data.di.coreDataModule
import com.ragnarok.core.database.di.databaseModule
import com.ragnarok.run.data.di.runDataModule
import com.ragnarok.run.location.di.locationModule
import com.ragnarok.run.network.di.networkModule
import com.ragnarok.run.presentation.di.runPresentationModule
import com.ragnarok.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }
}