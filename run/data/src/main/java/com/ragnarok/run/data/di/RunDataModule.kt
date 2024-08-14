package com.ragnarok.run.data.di

import com.ragnarok.run.data.CreateRunWorker
import com.ragnarok.run.data.DeleteRunWorker
import com.ragnarok.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}