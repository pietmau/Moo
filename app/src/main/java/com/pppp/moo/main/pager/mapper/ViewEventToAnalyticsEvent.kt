package com.pppp.moo.main.pager.mapper

import com.pppp.moo.main.pager.PagerView.Event
import com.pppp.moo.main.pager.analytics.PagerAnalytics
import com.pppp.moo.main.pager.analytics.PagerAnalytics.Event.ViewEvent

internal object ViewEventToAnalyticsEvent : (Event) -> PagerAnalytics.Event? {

    override fun invoke(event: Event): PagerAnalytics.Event? =
        ViewEvent(event)
}
