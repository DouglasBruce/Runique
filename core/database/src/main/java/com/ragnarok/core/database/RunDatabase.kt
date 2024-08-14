package com.ragnarok.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ragnarok.core.database.dao.AnalyticsDao
import com.ragnarok.core.database.dao.RunDao
import com.ragnarok.core.database.dao.RunPendingSyncDao
import com.ragnarok.core.database.entity.DeletedRunSyncEntity
import com.ragnarok.core.database.entity.RunEntity
import com.ragnarok.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class,
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val analyticsDao: AnalyticsDao
}