package com.pppp.moo.main.tabbed_switcher.mapper

import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherView.Event
import com.pppp.moo.main.tabbed_switcher.analytics.TabbedSwitcherAnalytics
import com.pppp.moo.main.tabbed_switcher.analytics.TabbedSwitcherAnalytics.Event.ViewEvent

internal object ViewEventToAnalyticsEvent : (Event) -> TabbedSwitcherAnalytics.Event? {

    override fun invoke(event: Event): TabbedSwitcherAnalytics.Event? =
        ViewEvent(event)
}
