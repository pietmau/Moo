package com.pppp.moo.main.tabs.mapper

import com.pppp.moo.main.tabs.TabsView.ViewModel
import com.pppp.moo.main.tabs.feature.TabsFeature.State

internal object StateToViewModel : (State) -> ViewModel {

    override fun invoke(state: State): ViewModel =
        TODO("Implement StateToViewModel mapping")
}
