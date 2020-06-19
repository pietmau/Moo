package com.pppp.moo.main.tabbed_switcher.builder

import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.badoo.ribs.core.builder.BuildParams
import com.pppp.moo.main.pager.Pager
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcher
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherNode
import dagger.BindsInstance

@TabbedSwitcherScope
@dagger.Component(
    modules = [TabbedSwitcherModule::class],
    dependencies = [TabbedSwitcher.Dependency::class]
)
internal interface TabbedSwitcherComponent {

    @dagger.Component.Factory
    interface Factory {
        fun create(
            dependency: TabbedSwitcher.Dependency,
            @BindsInstance activity: AppCompatActivity,
            @BindsInstance customisation: TabbedSwitcher.Customisation,
            @BindsInstance buildParams: BuildParams<TabbedSwitcherBuilder.Params>
        ): TabbedSwitcherComponent
    }

    fun node(): TabbedSwitcherNode
}
