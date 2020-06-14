package com.pppp.moo.main.pager.mapper

import com.pppp.moo.main.pager.Pager.Input
import com.pppp.moo.main.pager.feature.PagerFeature.Wish

internal object InputToWish : (Input) -> Wish? {

    override fun invoke(event: Input): Wish? =
        TODO("Implement PagerInputToWish mapping")
}
