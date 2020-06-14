package com.pppp.moo.tabbed_switcher

import com.badoo.ribs.core.builder.BuildParams
import com.pppp.moo.tabbed_switcher.feature.TabbedSwitcherFeature
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.After
import org.junit.Before
import org.junit.Test

class TabbedSwitcherInteractorTest {

    private val buildParams: BuildParams<Nothing?> = mock()
    private val input: ObservableSource<TabbedSwitcher.Input> = mock()
    private val output: Consumer<TabbedSwitcher.Output> = mock()
    private val feature: TabbedSwitcherFeature = mock()
    private val router: TabbedSwitcherRouter = mock()
    private lateinit var interactor: TabbedSwitcherInteractor

    @Before
    fun setup() {
        interactor = TabbedSwitcherInteractor(
            buildParams = buildParams,
            input = input,
            output = output,
            feature = feature,
            router = router
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
