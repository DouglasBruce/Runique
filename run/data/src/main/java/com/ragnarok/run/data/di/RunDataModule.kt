package com.ragnarok.run.data.di

import com.ragnarok.core.domain.run.SyncRunScheduler
import com.ragnarok.run.data.CreateRunWorker
import com.ragnarok.run.data.DeleteRunWorker
import com.ragnarok.run.data.FetchRunsWorker
import com.ragnarok.run.data.SyncRunWorkerScheduler
import com.ragnarok.run.data.connectivity.PhoneToWatchConnector
import com.ragnarok.run.domain.WatchConnector
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
    singleOf(::PhoneToWatchConnector).bind<WatchConnector>()
}