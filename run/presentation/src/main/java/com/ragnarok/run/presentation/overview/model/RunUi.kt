package com.ragnarok.run.presentation.overview.model

data class RunUi(
    val id: String,
    val duration: String,
    val dateTime: String,
    val distance: String,
    val avgSpeed: String,
    val maxSpeed: String,
    val pace: String,
    val totalElevation: String,
    val mapPictureUrl: String?,
    val avgHeartRate: String,
    val maxHeartRate: String
)
