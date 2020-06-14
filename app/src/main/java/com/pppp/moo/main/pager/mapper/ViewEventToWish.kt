package com.pppp.moo.main.pager.mapper

import com.pppp.moo.main.pager.PagerView.Event
import com.pppp.moo.main.pager.feature.PagerFeature.Wish

internal object ViewEventToWish : (Event) -> Wish? {

    override fun invoke(event: Event): Wish? =
        TODO("Implement PagerViewEventToWish mapping")
}
