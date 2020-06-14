package com.pppp.moo.tabbed_switcher

import com.badoo.ribs.core.builder.BuildContext.Companion.root
import com.pppp.moo.tabbed_switcher.builder.TabbedSwitcherBuilder
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.After
import org.junit.Before
import org.junit.Test

class TabbedSwitcherWorkflowTest {

    private lateinit var workflow: TabbedSwitcher

    @Before
    fun setup() {
        workflow = TabbedSwitcherBuilder(object : TabbedSwitcher.Dependency {
            override fun tabbedSwitcherInput(): ObservableSource<TabbedSwitcher.Input> = mock()
            override fun tabbedSwitcherOutput(): Consumer<TabbedSwitcher.Output> = mock()
        }).build(
            buildContext = root(savedInstanceState = null),
            payload = TabbedSwitcherBuilder.Params(someField = 3)
        ).also {
            it.node.onAttach()
        }
    }

    @After
    fun tearDown() {
    }

    /**
     * TODO: Add tests for every workflow action that operates on the node
     */
    @Test
    fun `business logic operation test`() {
        workflow.businessLogicOperation()
        // verify(feature).accept(Wish)

        throw RuntimeException("Add real tests.")
    }

    /**
     * TODO: Add tests for every workflow action that attaches a child to ensure workflow step can be fulfilled
     */
    @Test
    fun `attach child workflow step is fulfillable`() {
        // val testObserver = TestObserver<Child.Workflow>()

        // workflow.attachChild1().subscribe(testObserver)

        // testObserver.assertValueCount(1)
        // testObserver.assertComplete()

        throw RuntimeException("Add real tests.")
    }
}
