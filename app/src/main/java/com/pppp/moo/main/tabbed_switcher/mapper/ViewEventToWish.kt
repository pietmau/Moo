package com.pppp.moo.main.tabbed_switcher.mapper

import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherView.Event
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature.Wish

internal object ViewEventToWish : (Event) -> Wish? {

    override fun invoke(event: Event): Wish? =
        TODO("Implement TabbedSwitcherViewEventToWish mapping")
}
