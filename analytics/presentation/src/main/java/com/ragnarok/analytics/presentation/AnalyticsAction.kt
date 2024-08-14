package com.ragnarok.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick : AnalyticsAction
}