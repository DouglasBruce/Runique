package com.ragnarok.core.presentation.ui

import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.time.Duration

fun Duration.formatted(isAmbientMode: Boolean = false): String {
    val totalSeconds = inWholeSeconds
    val hours = String.format("%02d", totalSeconds / (60 * 60))
    val minutes = String.format("%02d", (totalSeconds % 3600) / 60)

    return if (isAmbientMode) {
        "$hours:$minutes"
    } else {
        val seconds = String.format("%02d", (totalSeconds % 60))
        "$hours:$minutes:$seconds"
    }
}

fun Double.toFormattedKm(): String {
    return "${this.roundToDecimals(1)} km"
}

fun Duration.toFormattedPace(distanceKm: Double): String {
    if (this == Duration.ZERO || distanceKm <= 0.0) {
        return "-"
    }

    val secondsPerKm = (this.inWholeSeconds / distanceKm).roundToInt()
    val avgPaceMinutes = secondsPerKm / 60
    val avgPaceSeconds = String.format("%02d", secondsPerKm % 60)

    return "$avgPaceMinutes:$avgPaceSeconds / km"
}

fun Double.toFormattedKmh(): String {
    return "${roundToDecimals(1)} km/h"
}

fun Int.toFormattedMeters(): String {
    return "$this m"
}

fun Int?.toFormattedHeartRate(): String {
    return if (this != null) "$this bpm" else "-"
}

private fun Double.roundToDecimals(decimalCount: Int): Double {
    val factor = 10f.pow(decimalCount)
    return round(this * factor) / factor
}