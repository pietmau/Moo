package com.pppp.moo.main.tabbed_switcher.mapper

import com.pppp.moo.main.tabbed_switcher.TabbedSwitcher.Input
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature.Wish

internal object InputToWish : (Input) -> Wish? {

    override fun invoke(event: Input): Wish? =
        TODO("Implement TabbedSwitcherInputToWish mapping")
}
