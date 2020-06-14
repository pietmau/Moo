package com.pppp.moo.main.tabs

import androidx.lifecycle.Lifecycle
import com.badoo.mvicore.android.lifecycle.createDestroy
import com.badoo.mvicore.android.lifecycle.startStop
import com.badoo.mvicore.binder.using
import com.badoo.ribs.core.Interactor
import com.badoo.ribs.core.builder.BuildParams
import com.pppp.moo.main.tabs.analytics.TabsAnalytics
import com.pppp.moo.main.tabs.feature.TabsFeature
import com.pppp.moo.main.tabs.mapper.InputToWish
import com.pppp.moo.main.tabs.mapper.NewsToOutput
import com.pppp.moo.main.tabs.mapper.StateToViewModel
import com.pppp.moo.main.tabs.mapper.ViewEventToAnalyticsEvent
import com.pppp.moo.main.tabs.mapper.ViewEventToWish

internal class TabsInteractor(
    buildParams: BuildParams<*>,
    private val feature: TabsFeature
) : Interactor<Tabs, TabsView>(
    buildParams = buildParams,
    disposables = feature
) {

    override fun onAttach(nodeLifecycle: Lifecycle) {
        nodeLifecycle.createDestroy {
            //bind(feature.news to rib.output using NewsToOutput)
            //bind(rib.input to feature using InputToWish)
        }
    }

    override fun onViewCreated(view: TabsView, viewLifecycle: Lifecycle) {
        viewLifecycle.startStop {
            //bind(feature to view using StateToViewModel)
            //bind(view to feature using ViewEventToWish)
            //bind(view to TabsAnalytics using ViewEventToAnalyticsEvent)
        }
    }
}
