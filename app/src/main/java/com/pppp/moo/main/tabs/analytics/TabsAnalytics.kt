package com.pppp.moo.main.tabs.analytics

import com.pppp.moo.main.tabs.TabsView
import io.reactivex.functions.Consumer

internal object TabsAnalytics : Consumer<TabsAnalytics.Event> {

    sealed class Event {
        data class ViewEvent(val event: TabsView.Event) : Event()
    }

    override fun accept(event: TabsAnalytics.Event) {
        // TODO Implement tracking
    }
}
