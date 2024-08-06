package com.ragnarok.run.presentation.active.maps

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import com.ragnarok.core.domain.location.LocationTimestamp
import kotlin.math.abs

object PolylineColorCalculator {

    fun locationsToColor(location1: LocationTimestamp, location2: LocationTimestamp): Color {
        val distanceMeters = location1.location.location.distanceTo(location2.location.location)
        val timeDiff =
            abs((location2.durationTimestamp - location1.durationTimestamp).inWholeSeconds)
        val speedKmh = (distanceMeters / timeDiff) * 3.6

        return interpolateColor(
            speedKmh = speedKmh
        )
    }

    private fun interpolateColor(
        speedKmh: Double,
        minSpeed: Double = 5.0,
        maxSpeed: Double = 20.0,
        colorStart: Color = Color.Green,
        colorMid: Color = Color.Yellow,
        colorEnd: Color = Color.Red
    ): Color {
        val ratio = ((speedKmh - minSpeed) / (maxSpeed - minSpeed)).coerceIn(0.0..1.0)
        val colorInt = if (ratio <= 0.5) {
            val midRatio = ratio / 0.5
            ColorUtils.blendARGB(colorStart.toArgb(), colorMid.toArgb(), midRatio.toFloat())
        } else {
            val midToEndRatio = (ratio - 0.5) / 0.5
            ColorUtils.blendARGB(colorMid.toArgb(), colorEnd.toArgb(), midToEndRatio.toFloat())
        }

        return Color(colorInt)
    }
}