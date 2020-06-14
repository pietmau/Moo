package com.pppp.moo.main.pager

import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.RoutingSource
import com.pppp.moo.main.pager.routing.PagerChildBuilders
import com.pppp.moo.main.pager.routing.PagerRouter
import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class PagerRouterTest {

    private val buildParams: BuildParams<Nothing?> = mock()
    private val builders: PagerChildBuilders = mock()
    private var router: PagerRouter? = null

    @Before
    fun setup() {
        router = PagerRouter(
            buildParams = buildParams,
            routingSource = RoutingSource.Empty(),
            builders = builders
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
