package com.ragnarok.run.network

import kotlinx.serialization.Serializable

@Serializable
data class CreateRunRequest(
    val durationMillis: Long,
    val distanceMeters: Int,
    val epochMillis: Long,
    val lat: Double,
    val long: Double,
    val avgSpeedKmh: Double,
    val maxSpeedKmh: Double,
    val totalElevationMeters: Int,
    val id: String,
    val avgHeartRate: Int?,
    val maxHeartRate: Int?,
)
