package com.pppp.moo.main.pager

import com.badoo.ribs.clienthelper.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.badoo.ribs.customisation.RibCustomisation
import com.pppp.moo.main.pager.Pager.Input
import com.pppp.moo.main.pager.Pager.Output
import com.pppp.moo.main.pager.routing.PagerRouter
import io.reactivex.Single

interface Pager : Rib, Connectable<Input, Output> {

    interface Dependency

    sealed class Input

    sealed class Output

    class Customisation(
        val viewFactory: PagerView.Factory = PagerViewImpl.Factory(),
        val transitionHandler: TransitionHandler<PagerRouter.Configuration>? = null
    ) : RibCustomisation

    // Workflow
    // todo: do not delete - rename, and add more
    // todo: expose all meaningful operations
    fun businessLogicOperation(): Single<Pager>

    // todo: expose all possible children (even permanent parts), or remove if there's none
    // fun attachChild1(): Single<Child>
}
