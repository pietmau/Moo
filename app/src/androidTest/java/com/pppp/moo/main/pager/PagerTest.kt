package com.pppp.moo.main.pager

import android.os.Bundle
import com.badoo.common.ribs.RibsRule
import com.badoo.ribs.RibTestActivity
import com.badoo.ribs.core.builder.BuildContext.Companion.root
import com.pppp.moo.main.pager.builder.PagerBuilder
import org.junit.Rule
import org.junit.Test

class PagerTest {

    @get:Rule
    val ribsRule = RibsRule { activity, savedInstanceState -> buildRib(activity, savedInstanceState) }

    private fun buildRib(ribTestActivity: RibTestActivity, savedInstanceState: Bundle?) =
        PagerBuilder(object : Pager.Dependency {}).build(
            buildContext = root(savedInstanceState),
            payload = PagerBuilder.Params(0)
        )


    @Test
    fun testTextDisplayed() {
        TODO("Write UI tests")
    }
}
