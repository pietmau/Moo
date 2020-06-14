package com.pppp.moo.main.tabbed_switcher.routing

import android.os.Parcelable
import com.badoo.ribs.core.Router
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.RoutingSource
import com.badoo.ribs.core.routing.action.RoutingAction
import com.badoo.ribs.core.routing.action.RoutingAction.Companion.noop
import com.badoo.ribs.core.routing.history.Routing
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherRouter.Configuration
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherRouter.Configuration.Content
import kotlinx.android.parcel.Parcelize

class TabbedSwitcherRouter internal constructor(
    buildParams: BuildParams<*>,
    routingSource: RoutingSource<Configuration>,
    private val builders: TabbedSwitcherChildBuilders,
    transitionHandler: TransitionHandler<Configuration>? = null
): Router<Configuration>(
    buildParams = buildParams,
    routingSource = routingSource,
    transitionHandler = transitionHandler
) {
    sealed class Configuration : Parcelable {
        sealed class Permanent : Configuration()
        sealed class Content : Configuration() {
            @Parcelize object Default : Content()
        }
        sealed class Overlay : Configuration()
    }

    override fun resolve(routing: Routing<Configuration>): RoutingAction =
        with(builders) {
            when (routing.configuration) {
                // TODO implement all branches
                //  to attach children use:
                //  Content.Child1 -> attach { child.build(it) }
                is Content.Default -> noop()
            }
        }
}
