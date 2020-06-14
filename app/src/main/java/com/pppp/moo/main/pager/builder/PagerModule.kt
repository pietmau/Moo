@file:SuppressWarnings("LongParameterList", "LongMethod")
package com.pppp.moo.main.pager.builder

import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.configuration.feature.BackStackFeature
import com.pppp.moo.main.pager.Pager
import com.pppp.moo.main.pager.PagerInteractor
import com.pppp.moo.main.pager.PagerNode
import com.pppp.moo.main.pager.routing.PagerRouter
import com.pppp.moo.main.pager.routing.PagerRouter.Configuration
import com.pppp.moo.main.pager.routing.PagerRouter.Configuration.Content
import com.pppp.moo.main.pager.builder.PagerBuilder.Params
import com.pppp.moo.main.pager.feature.PagerFeature
import com.pppp.moo.main.pager.routing.PagerChildBuilders
import dagger.Provides

@dagger.Module
internal object PagerModule {

    @PagerScope
    @Provides
    @JvmStatic
    internal fun feature(): PagerFeature =
        PagerFeature()

    @PagerScope
    @Provides
    @JvmStatic
    internal fun backStack(
        buildParams: BuildParams<Params>
    ): BackStackFeature<Configuration> =
        BackStackFeature(
            buildParams = buildParams,
            initialConfiguration = Content.Default
        )

    @PagerScope
    @Provides
    @JvmStatic
    internal fun interactor(
        dependency: Pager.Dependency,
        buildParams: BuildParams<Params>,
        backStack: BackStackFeature<Configuration>,
        feature: PagerFeature
    ): PagerInteractor =
        PagerInteractor(
            buildParams = buildParams,
            backStack= backStack,
            feature = feature
        )

    @PagerScope
    @Provides
    @JvmStatic
    internal fun childBuilders(
        component: PagerComponent
    ): PagerChildBuilders =
        PagerChildBuilders(
            // child1 = Child1Builder(component)
        )

    @PagerScope
    @Provides
    @JvmStatic
    internal fun router(
        buildParams: BuildParams<Params>,
        backStack: BackStackFeature<Configuration>,
        builders: PagerChildBuilders,
        customisation: Pager.Customisation
    ): PagerRouter =
        PagerRouter(
            buildParams = buildParams,
            routingSource = backStack,
            builders = builders,
            transitionHandler = customisation.transitionHandler
        )

    @PagerScope
    @Provides
    @JvmStatic
    internal fun node(
        buildParams: BuildParams<Params>,
        customisation: Pager.Customisation,
        interactor: PagerInteractor,
        router: PagerRouter
    ) : PagerNode = PagerNode(
        buildParams = buildParams,
        viewFactory = customisation.viewFactory(null),
        plugins = listOf(interactor, router)
    )
}
