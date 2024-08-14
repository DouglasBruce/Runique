package com.ragnarok.run.presentation.overview

import com.ragnarok.run.presentation.overview.model.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)
