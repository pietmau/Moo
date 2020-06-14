package com.pppp.moo.main.tabs.mapper

import com.pppp.moo.main.tabs.Tabs.Output
import com.pppp.moo.main.tabs.feature.TabsFeature.News

internal object NewsToOutput : (News) -> Output? {

    override fun invoke(news: News): Output? =
        TODO("Implement TabsNewsToOutput mapping")
}
