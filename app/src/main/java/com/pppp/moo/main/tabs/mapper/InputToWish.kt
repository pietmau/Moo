package com.pppp.moo.main.tabs.mapper

import com.pppp.moo.main.tabs.Tabs.Input
import com.pppp.moo.main.tabs.feature.TabsFeature.Wish

internal object InputToWish : (Input) -> Wish? {

    override fun invoke(event: Input): Wish? =
        TODO("Implement TabsInputToWish mapping")
}
