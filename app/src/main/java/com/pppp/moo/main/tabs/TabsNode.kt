package com.pppp.moo.main.tabs

import android.view.ViewGroup
import com.badoo.ribs.clienthelper.Connectable
import com.badoo.ribs.clienthelper.NodeConnector
import com.badoo.ribs.core.Node
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.plugin.Plugin
import com.pppp.moo.main.tabs.Tabs.Input
import com.pppp.moo.main.tabs.Tabs.Output
import io.reactivex.Single

class TabsNode internal constructor(
    buildParams: BuildParams<*>,
    viewFactory: ((ViewGroup) -> TabsView?)?,
    plugins: List<Plugin> = emptyList(),
    connector: NodeConnector<Input, Output> = NodeConnector()
) : Node<TabsView>(
    buildParams = buildParams,
    viewFactory = viewFactory,
    plugins = plugins
), Tabs, Connectable<Input, Output> by connector {

    /**
     * TODO:
     *  - use router / input / output / feature for Tabs method implementations
     *  - keep in mind that in most cases you probably don't need to use interactor reference directly
     *      - its lifecycle methods are not accessible publicly (and it's good this way)
     *      - its internal consumers are usually reacting to children, and then it's better to
     *          trigger child workflows instead of faking them directly on the parent
     *  - as a general advice, try to trigger actions at points that are closest to where they would happen naturally,
     *      such that triggering involves executing all related actions (analytics, logging, etc)
     */

    override fun businessLogicOperation(): Single<Tabs> =
        executeWorkflow {
            // todo e.g. push wish to feature / trigger input / output
            // feature.accept()
        }
}
