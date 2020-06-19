package com.pppp.moo.main.tabbed_switcher.builder

import androidx.appcompat.app.AppCompatActivity
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.builder.Builder
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcher
import com.pppp.moo.main.tabbed_switcher.builder.TabbedSwitcherBuilder.Params

class TabbedSwitcherBuilder(
    private val dependency: TabbedSwitcher.Dependency,
    private val activity: AppCompatActivity
) : Builder<Params, TabbedSwitcher>() {

    data class Params(
        val someField: Any
    )

    override fun build(buildParams: BuildParams<Params>): TabbedSwitcher =
        DaggerTabbedSwitcherComponent
            .factory()
            .create(
                dependency = dependency,
                activity = activity,
                customisation = buildParams.getOrDefault(TabbedSwitcher.Customisation()),
                buildParams = buildParams
            )
            .node()
}
