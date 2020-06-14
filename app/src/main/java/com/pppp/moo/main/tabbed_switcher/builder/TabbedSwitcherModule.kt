@file:SuppressWarnings("LongParameterList", "LongMethod")
package com.pppp.moo.main.tabbed_switcher.builder

import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.configuration.feature.BackStackFeature
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcher
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherInteractor
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherNode
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherRouter
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherRouter.Configuration
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherRouter.Configuration.Content
import com.pppp.moo.main.tabbed_switcher.builder.TabbedSwitcherBuilder.Params
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature
import com.pppp.moo.main.tabbed_switcher.routing.TabbedSwitcherChildBuilders
import dagger.Provides

@dagger.Module
internal object TabbedSwitcherModule {

    @TabbedSwitcherScope
    @Provides
    @JvmStatic
    internal fun feature(): TabbedSwitcherFeature =
        TabbedSwitcherFeature()

    @TabbedSwitcherScope
    @Provides
    @JvmStatic
    internal fun backStack(
        buildParams: BuildParams<Params>
    ): BackStackFeature<Configuration> =
        BackStackFeature(
            buildParams = buildParams,
            initialConfiguration = Content.Default
        )

    @TabbedSwitcherScope
    @Provides
    @JvmStatic
    internal fun interactor(
        dependency: TabbedSwitcher.Dependency,
        buildParams: BuildParams<Params>,
        backStack: BackStackFeature<Configuration>,
        feature: TabbedSwitcherFeature
    ): TabbedSwitcherInteractor =
        TabbedSwitcherInteractor(
            buildParams = buildParams,
            backStack= backStack,
            feature = feature
        )

    @TabbedSwitcherScope
    @Provides
    @JvmStatic
    internal fun childBuilders(
        component: TabbedSwitcherComponent
    ): TabbedSwitcherChildBuilders =
        TabbedSwitcherChildBuilders(
            // child1 = Child1Builder(component)
        )

    @TabbedSwitcherScope
    @Provides
    @JvmStatic
    internal fun router(
        buildParams: BuildParams<Params>,
        backStack: BackStackFeature<Configuration>,
        builders: TabbedSwitcherChildBuilders,
        customisation: TabbedSwitcher.Customisation
    ): TabbedSwitcherRouter =
        TabbedSwitcherRouter(
            buildParams = buildParams,
            routingSource = backStack,
            builders = builders,
            transitionHandler = customisation.transitionHandler
        )

    @TabbedSwitcherScope
    @Provides
    @JvmStatic
    internal fun node(
        buildParams: BuildParams<Params>,
        customisation: TabbedSwitcher.Customisation,
        interactor: TabbedSwitcherInteractor,
        router: TabbedSwitcherRouter
    ) : TabbedSwitcherNode = TabbedSwitcherNode(
        buildParams = buildParams,
        viewFactory = customisation.viewFactory(null),
        plugins = listOf(interactor, router)
    )
}
