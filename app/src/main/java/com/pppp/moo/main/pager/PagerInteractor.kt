package com.pppp.moo.main.pager

import androidx.lifecycle.Lifecycle
import com.badoo.mvicore.android.lifecycle.createDestroy
import com.badoo.mvicore.android.lifecycle.startStop
import com.badoo.mvicore.binder.using
import com.badoo.ribs.core.Interactor
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.configuration.feature.BackStackFeature
import com.pppp.moo.main.pager.routing.PagerRouter.Configuration
import com.pppp.moo.main.pager.analytics.PagerAnalytics
import com.pppp.moo.main.pager.feature.PagerFeature
import com.pppp.moo.main.pager.mapper.InputToWish
import com.pppp.moo.main.pager.mapper.NewsToOutput
import com.pppp.moo.main.pager.mapper.StateToViewModel
import com.pppp.moo.main.pager.mapper.ViewEventToAnalyticsEvent
import com.pppp.moo.main.pager.mapper.ViewEventToWish

internal class PagerInteractor(
    buildParams: BuildParams<*>,
    private val backStack: BackStackFeature<Configuration>,
    private val feature: PagerFeature
) : Interactor<Pager, PagerView>(
    buildParams = buildParams,
    disposables = feature
) {

    override fun onAttach(nodeLifecycle: Lifecycle) {
        nodeLifecycle.createDestroy {
            //bind(feature.news to rib.output using NewsToOutput)
            //bind(rib.input to feature using InputToWish)
        }
    }

    override fun onViewCreated(view: PagerView, viewLifecycle: Lifecycle) {
        viewLifecycle.startStop {
            //bind(feature to view using StateToViewModel)
            //bind(view to feature using ViewEventToWish)
            //bind(view to PagerAnalytics using ViewEventToAnalyticsEvent)
        }
    }
}
