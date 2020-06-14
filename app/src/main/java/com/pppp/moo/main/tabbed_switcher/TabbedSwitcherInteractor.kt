package com.pppp.moo.main.tabbed_switcher

import androidx.lifecycle.Lifecycle
import com.badoo.mvicore.android.lifecycle.createDestroy
import com.badoo.mvicore.android.lifecycle.startStop
import com.badoo.mvicore.binder.using
import com.badoo.ribs.core.Interactor
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.configuration.feature.BackStackFeature
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherRouter.Configuration
import com.pppp.moo.main.tabbed_switcher.analytics.TabbedSwitcherAnalytics
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature
import com.pppp.moo.main.tabbed_switcher.mapper.InputToWish
import com.pppp.moo.main.tabbed_switcher.mapper.NewsToOutput
import com.pppp.moo.main.tabbed_switcher.mapper.StateToViewModel
import com.pppp.moo.main.tabbed_switcher.mapper.ViewEventToAnalyticsEvent
import com.pppp.moo.main.tabbed_switcher.mapper.ViewEventToWish

internal class TabbedSwitcherInteractor(
    buildParams: BuildParams<*>,
    private val backStack: BackStackFeature<Configuration>,
    private val feature: TabbedSwitcherFeature
) : Interactor<TabbedSwitcher, TabbedSwitcherView>(
    buildParams = buildParams,
    disposables = feature
) {

    override fun onAttach(nodeLifecycle: Lifecycle) {
        nodeLifecycle.createDestroy {
            //bind(feature.news to rib.output using NewsToOutput)
            //bind(rib.input to feature using InputToWish)
        }
    }

    override fun onViewCreated(view: TabbedSwitcherView, viewLifecycle: Lifecycle) {
        viewLifecycle.startStop {
            //bind(feature to view using StateToViewModel)
            //bind(view to feature using ViewEventToWish)
            //bind(view to TabbedSwitcherAnalytics using ViewEventToAnalyticsEvent)
        }
    }
}
