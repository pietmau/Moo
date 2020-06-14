package com.pppp.moo.main.pager

import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.routing.configuration.feature.BackStackFeature
import com.pppp.moo.main.pager.feature.PagerFeature
import com.pppp.moo.main.pager.routing.PagerRouter.Configuration
import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Before
import org.junit.Test

class PagerInteractorTest {

    private val buildParams: BuildParams<Nothing?> = mock()
    private val feature: PagerFeature = mock()
    private val backStack: BackStackFeature<Configuration> = mock()
    private lateinit var interactor: PagerInteractor

    @Before
    fun setup() {
        interactor = PagerInteractor(
            buildParams = buildParams,
            feature = feature,
            backStack = backStack
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
