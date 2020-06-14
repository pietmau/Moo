package com.pppp.moo.main.tabs

import android.os.Parcelable
import com.badoo.mvicore.android.AndroidTimeCapsule
import com.badoo.mvicore.element.TimeCapsule
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.builder.SimpleBuilder
import com.pppp.moo.main.tabs.feature.TabsFeature

class TabsBuilder(
    private val dependency: Tabs.Dependency
) : SimpleBuilder<Tabs>() {

    override fun build(buildParams: BuildParams<Nothing?>): Tabs {
        val customisation = buildParams.getOrDefault(Tabs.Customisation())
        val feature = feature(AndroidTimeCapsule(buildParams.savedInstanceState))
        val interactor = interactor(buildParams, feature)

        return node(buildParams, customisation, interactor)
    }

    private fun feature(androidTimeCapsule: TimeCapsule<Parcelable>) =
        TabsFeature(androidTimeCapsule)

    private fun interactor(
        buildParams: BuildParams<*>,
        feature: TabsFeature
    ) =
        TabsInteractor(
            buildParams = buildParams,
            feature = feature
        )

    private fun node(
        buildParams: BuildParams<Nothing?>,
        customisation: Tabs.Customisation,
        interactor: TabsInteractor
    ) =
        TabsNode(
            buildParams = buildParams,
            viewFactory = customisation.viewFactory(null),
            plugins = listOf(interactor)
        )
}
