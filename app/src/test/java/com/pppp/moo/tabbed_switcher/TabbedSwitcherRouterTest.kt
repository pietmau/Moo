package com.pppp.moo.tabbed_switcher

import com.badoo.ribs.core.builder.BuildParams
import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class TabbedSwitcherRouterTest {

    private val buildParams: BuildParams<Nothing?> = mock()
    private var router: TabbedSwitcherRouter? = null

    @Before
    fun setup() {
        router = TabbedSwitcherRouter(
            buildParams = buildParams
        )
    }

    @After
    fun tearDown() {
    }

    /**
     * TODO: Add real tests.
     */
    @Test
    fun `an example test with some conditions should pass`() {
        throw RuntimeException("Add real tests.")
    }
}
