package com.pppp.moo.main.tabbed_switcher

import com.badoo.ribs.clienthelper.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.badoo.ribs.customisation.RibCustomisation
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcher.Input
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcher.Output
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherRouter
import io.reactivex.Single

interface TabbedSwitcher : Rib, Connectable<Input, Output> {

    interface Dependency

    sealed class Input

    sealed class Output

    class Customisation(
        val viewFactory: TabbedSwitcherView.Factory = TabbedSwitcherViewImpl.Factory(),
        val transitionHandler: TransitionHandler<TabbedSwitcherRouter.Configuration>? = null
    ) : RibCustomisation

    // Workflow
    // todo: do not delete - rename, and add more
    // todo: expose all meaningful operations
    fun businessLogicOperation(): Single<TabbedSwitcher>

    // todo: expose all possible children (even permanent parts), or remove if there's none
    // fun attachChild1(): Single<Child>
}
