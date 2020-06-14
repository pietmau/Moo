package com.pppp.moo.main.pager.routing

import android.os.Parcelable
import com.badoo.ribs.core.Router
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.RoutingSource
import com.badoo.ribs.core.routing.action.RoutingAction
import com.badoo.ribs.core.routing.action.RoutingAction.Companion.noop
import com.badoo.ribs.core.routing.history.Routing
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.pppp.moo.main.pager.routing.PagerRouter.Configuration
import com.pppp.moo.main.pager.routing.PagerRouter.Configuration.Content
import kotlinx.android.parcel.Parcelize

class PagerRouter internal constructor(
    buildParams: BuildParams<*>,
    routingSource: RoutingSource<Configuration>,
    private val builders: PagerChildBuilders,
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
