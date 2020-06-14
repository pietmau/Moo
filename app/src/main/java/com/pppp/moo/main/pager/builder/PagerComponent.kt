package com.pppp.moo.main.pager.builder

import com.badoo.ribs.core.builder.BuildParams
import com.pppp.moo.main.pager.Pager
import com.pppp.moo.main.pager.PagerNode
import dagger.BindsInstance

@PagerScope
@dagger.Component(
    modules = [PagerModule::class],
    dependencies = [Pager.Dependency::class]
)
internal interface PagerComponent {

    @dagger.Component.Factory
    interface Factory {
        fun create(
            dependency: Pager.Dependency,
            @BindsInstance customisation: Pager.Customisation,
            @BindsInstance buildParams: BuildParams<PagerBuilder.Params>
        ): PagerComponent
    }

    fun node(): PagerNode
}
