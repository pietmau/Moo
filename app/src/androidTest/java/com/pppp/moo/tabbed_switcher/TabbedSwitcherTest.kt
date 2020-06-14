package com.pppp.moo.tabbed_switcher

import android.os.Bundle
import com.badoo.common.ribs.RibsRule
import com.badoo.ribs.RibTestActivity
import com.badoo.ribs.core.builder.BuildContext.Companion.root
import com.pppp.moo.tabbed_switcher.builder.TabbedSwitcherBuilder
import io.reactivex.Observable.empty
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.Rule
import org.junit.Test

class TabbedSwitcherTest {

    @get:Rule
    val ribsRule = RibsRule { activity, savedInstanceState -> buildRib(activity, savedInstanceState) }

    private fun buildRib(ribTestActivity: RibTestActivity, savedInstanceState: Bundle?) =
        TabbedSwitcherBuilder(object : TabbedSwitcher.Dependency {
            override fun tabbedSwitcherInput(): ObservableSource<TabbedSwitcher.Input> = empty()
            override fun tabbedSwitcherOutput(): Consumer<TabbedSwitcher.Output> = Consumer {}
        }).build(
            buildContext = root(savedInstanceState),
            payload = TabbedSwitcherBuilder.Params(0)
        )

    @Test
    fun testTextDisplayed() {
        TODO("Write UI tests")
    }
}
