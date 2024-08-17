package com.ragnarok.wear.run.presentation

sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
}