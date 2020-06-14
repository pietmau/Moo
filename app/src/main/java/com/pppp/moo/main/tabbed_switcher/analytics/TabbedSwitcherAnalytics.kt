package com.pppp.moo.main.tabbed_switcher.analytics

import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherView
import io.reactivex.functions.Consumer

internal object TabbedSwitcherAnalytics : Consumer<TabbedSwitcherAnalytics.Event> {

    sealed class Event {
        data class ViewEvent(val event: TabbedSwitcherView.Event) : Event()
    }

    override fun accept(event: TabbedSwitcherAnalytics.Event) {
        // TODO Implement tracking
    }
}
