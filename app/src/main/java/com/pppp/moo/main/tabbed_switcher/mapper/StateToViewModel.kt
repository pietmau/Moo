package com.pppp.moo.main.tabbed_switcher.mapper

import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherView.ViewModel
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature.State

internal object StateToViewModel : (State) -> ViewModel {

    override fun invoke(state: State): ViewModel =
        TODO("Implement StateToViewModel mapping")
}
