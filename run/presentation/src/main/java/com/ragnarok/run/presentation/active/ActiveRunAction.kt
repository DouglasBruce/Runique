package com.ragnarok.run.presentation.active

sealed interface ActiveRunAction {
    data object OnToggleRunClick: ActiveRunAction
    data object OnFinishRunClick: ActiveRunAction
    data object OnResumeRunClick: ActiveRunAction
    data object OnBackClick: ActiveRunAction
    data class SubmitLocationPermissionInfo(
        val acceptedLocationPermission: Boolean,
        val showLocationRationale: Boolean
    ): ActiveRunAction
    data class SubmitNotificationPermissionInfo(
        val acceptedNotificationPermission: Boolean,
        val showNotificationRationale: Boolean
    ): ActiveRunAction
    data object DismissRationaleDialog: ActiveRunAction
}