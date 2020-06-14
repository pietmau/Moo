package com.pppp.moo.main.pager.mapper

import com.pppp.moo.main.pager.PagerView.ViewModel
import com.pppp.moo.main.pager.feature.PagerFeature.State

internal object StateToViewModel : (State) -> ViewModel {

    override fun invoke(state: State): ViewModel =
        TODO("Implement StateToViewModel mapping")
}
