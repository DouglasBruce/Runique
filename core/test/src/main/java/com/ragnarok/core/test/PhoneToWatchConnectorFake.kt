package com.ragnarok.core.test

import com.ragnarok.core.connectivity.domain.DeviceNode
import com.ragnarok.core.connectivity.domain.messaging.MessagingAction
import com.ragnarok.core.connectivity.domain.messaging.MessagingError
import com.ragnarok.core.domain.util.EmptyResult
import com.ragnarok.core.domain.util.Result
import com.ragnarok.run.domain.WatchConnector
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class PhoneToWatchConnectorFake: WatchConnector {

    var sendError: MessagingError? = null

    private val _isTrackable = MutableStateFlow(true)

    private val _connectedDevice = MutableStateFlow<DeviceNode?>(null)
    override val connectedDevice: StateFlow<DeviceNode?>
        get() = _connectedDevice.asStateFlow()

    private val _messagingActions = MutableSharedFlow<MessagingAction>()
    override val messagingActions: Flow<MessagingAction>
        get() = _messagingActions.asSharedFlow()

    override suspend fun sendActionToWatch(action: MessagingAction): EmptyResult<MessagingError> {
        return if(sendError == null) {
            Result.Success(Unit)
        } else {
            Result.Error(sendError!!)
        }
    }

    override fun setIsTrackable(isTrackable: Boolean) {
        this._isTrackable.value = isTrackable
    }

    suspend fun sendFromWatchToPhone(action: MessagingAction) {
        _messagingActions.emit(action)
    }
}