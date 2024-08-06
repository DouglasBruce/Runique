package com.ragnarok.run.presentation.active.maps

import androidx.compose.ui.graphics.Color
import com.ragnarok.core.domain.location.Location

data class PolylineUi(
    val location1: Location,
    val location2: Location,
    val color: Color
)
