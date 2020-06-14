package com.pppp.moo.main.tabs

import com.badoo.ribs.core.builder.BuildParams
import com.pppp.moo.main.tabs.feature.TabsFeature
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.After
import org.junit.Before
import org.junit.Test

class TabsInteractorTest {

    private val feature: TabsFeature = mock()
    private lateinit var interactor: TabsInteractor

    @Before
    fun setup() {
        interactor = TabsInteractor(
            buildParams = BuildParams.Empty(),
            feature = feature
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
