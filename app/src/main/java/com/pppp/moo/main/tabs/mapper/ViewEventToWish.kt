package com.pppp.moo.main.tabs.mapper

import com.pppp.moo.main.tabs.TabsView.Event
import com.pppp.moo.main.tabs.feature.TabsFeature.Wish

internal object ViewEventToWish : (Event) -> Wish? {

    override fun invoke(event: Event): Wish? = Wish.Bar
}
