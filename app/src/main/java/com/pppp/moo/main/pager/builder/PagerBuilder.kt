package com.pppp.moo.main.pager.builder

import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.builder.Builder
import com.pppp.moo.main.pager.Pager
import com.pppp.moo.main.pager.builder.PagerBuilder.Params

class PagerBuilder(
    private val dependency: Pager.Dependency
) : Builder<Params, Pager>() {

    data class Params(
        val someField: Any
    )

    override fun build(buildParams: BuildParams<Params>): Pager =
        DaggerPagerComponent
            .factory()
            .create(
                dependency = dependency,
                customisation = buildParams.getOrDefault(Pager.Customisation()),
                buildParams = buildParams
            )
            .node()
}
