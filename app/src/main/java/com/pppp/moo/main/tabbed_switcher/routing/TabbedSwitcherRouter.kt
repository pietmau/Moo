package com.pppp.moo.main.tabbed_switcher.routing

import android.os.Parcelable
import com.badoo.ribs.core.Router
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.RoutingSource
import com.badoo.ribs.core.routing.action.AttachRibRoutingAction.Companion.attach
import com.badoo.ribs.core.routing.action.CompositeRoutingAction.Companion.composite
import com.badoo.ribs.core.routing.action.RoutingAction
import com.badoo.ribs.core.routing.history.Routing
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.pppp.moo.main.pager.Pager
import com.pppp.moo.main.pager.builder.PagerBuilder
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherRouter.Configuration
import com.pppp.moo.main.tabs.Tabs
import com.pppp.moo.main.tabs.TabsBuilder
import kotlinx.android.parcel.Parcelize

class TabbedSwitcherRouter internal constructor(
    val buildParams: BuildParams<*>,
    routingSource: RoutingSource<Configuration>,
    private val builders: TabbedSwitcherChildBuilders,
    transitionHandler: TransitionHandler<Configuration>? = null
) : Router<Configuration>(
    buildParams = buildParams,
    routingSource = routingSource,
    transitionHandler = transitionHandler
) {
    sealed class Configuration : Parcelable {
        @Parcelize
        object Default : Configuration()
    }

    override fun resolve(routing: Routing<Configuration>): RoutingAction =
        when (routing.configuration) {
            is Configuration.Default -> composite(
                attach { PagerBuilder(object : Pager.Dependency {}).build(it, PagerBuilder.Params("")) },
                attach { TabsBuilder(object : Tabs.Dependency {}).build(it) }
            )
        }

}
