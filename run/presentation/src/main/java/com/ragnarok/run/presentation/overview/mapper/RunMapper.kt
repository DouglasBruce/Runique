package com.ragnarok.run.presentation.overview.mapper

import com.ragnarok.core.domain.run.Run
import com.ragnarok.core.presentation.ui.formatted
import com.ragnarok.core.presentation.ui.toFormattedKm
import com.ragnarok.core.presentation.ui.toFormattedKmh
import com.ragnarok.core.presentation.ui.toFormattedMeters
import com.ragnarok.core.presentation.ui.toFormattedPace
import com.ragnarok.run.presentation.overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeLocal = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeLocal)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl
    )
}