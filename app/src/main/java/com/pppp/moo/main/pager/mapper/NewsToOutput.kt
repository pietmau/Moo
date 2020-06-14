package com.pppp.moo.main.pager.mapper

import com.pppp.moo.main.pager.Pager.Output
import com.pppp.moo.main.pager.feature.PagerFeature.News

internal object NewsToOutput : (News) -> Output? {

    override fun invoke(news: News): Output? =
        TODO("Implement PagerNewsToOutput mapping")
}
