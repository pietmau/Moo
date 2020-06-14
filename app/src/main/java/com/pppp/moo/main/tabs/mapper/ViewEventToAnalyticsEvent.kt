package com.pppp.moo.main.tabs.mapper

import com.pppp.moo.main.tabs.TabsView.Event
import com.pppp.moo.main.tabs.analytics.TabsAnalytics
import com.pppp.moo.main.tabs.analytics.TabsAnalytics.Event.ViewEvent

internal object ViewEventToAnalyticsEvent : (Event) -> TabsAnalytics.Event? {

    override fun invoke(event: Event): TabsAnalytics.Event? =
        ViewEvent(event)
}
