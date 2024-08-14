package com.ragnarok.run.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ragnarok.core.database.dao.RunPendingSyncDao
import com.ragnarok.core.database.mappers.toRun
import com.ragnarok.core.domain.run.RemoteRunDataSource

class CreateRunWorker(
    context: Context,
    private val params: WorkerParameters,
    private val remoteRunDataSource: RemoteRunDataSource,
    private val runPendingSyncDao: RunPendingSyncDao
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        if (runAttemptCount >= 5) {
            return Result.failure()
        }

        val pendingRunId = params.inputData.getString(RUN_ID) ?: return Result.failure()
        val pendingRunEntity =
            runPendingSyncDao.getRunPendingSyncEntity(pendingRunId) ?: return Result.failure()

        val run = pendingRunEntity.run.toRun()
        return when (val result =
            remoteRunDataSource.postRun(run, pendingRunEntity.mapPictureBytes)) {
            is com.ragnarok.core.domain.util.Result.Error -> {
                result.error.toWorkerResult()
            }

            is com.ragnarok.core.domain.util.Result.Success -> {
                runPendingSyncDao.deleteRunPendingSyncEntity(pendingRunId)
                Result.success()
            }
        }
    }

    companion object {
        const val RUN_ID = "RUN_ID"
    }
}