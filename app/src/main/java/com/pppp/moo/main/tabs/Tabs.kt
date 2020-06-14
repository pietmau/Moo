package com.pppp.moo.main.tabs

import com.badoo.ribs.clienthelper.Connectable
import com.badoo.ribs.core.Rib
import com.badoo.ribs.customisation.RibCustomisation
import com.pppp.moo.main.tabs.Tabs.Input
import com.pppp.moo.main.tabs.Tabs.Output
import io.reactivex.Single

interface Tabs : Rib, Connectable<Input, Output> {

    interface Dependency

    sealed class Input

    sealed class Output

    class Customisation(
        val viewFactory: TabsView.Factory = TabsViewImpl.Factory()
    ) : RibCustomisation

    // Workflow
    // todo: do not delete - rename, and add more
    // todo: expose all meaningful operations
    fun businessLogicOperation(): Single<Tabs>

    // todo: expose all possible children (even permanent parts), or remove if there's none
    // fun attachChild1(): Single<Child>
}
