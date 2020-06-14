package com.pppp.moo.main.tabbed_switcher.mapper

import com.pppp.moo.main.tabbed_switcher.TabbedSwitcher.Output
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature.News

internal object NewsToOutput : (News) -> Output? {

    override fun invoke(news: News): Output? =
        TODO("Implement TabbedSwitcherNewsToOutput mapping")
}
