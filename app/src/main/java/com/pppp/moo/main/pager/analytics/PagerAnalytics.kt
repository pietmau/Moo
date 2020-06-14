package com.pppp.moo.main.pager.analytics

import com.pppp.moo.main.pager.PagerView
import io.reactivex.functions.Consumer

internal object PagerAnalytics : Consumer<PagerAnalytics.Event> {

    sealed class Event {
        data class ViewEvent(val event: PagerView.Event) : Event()
    }

    override fun accept(event: PagerAnalytics.Event) {
        // TODO Implement tracking
    }
}
