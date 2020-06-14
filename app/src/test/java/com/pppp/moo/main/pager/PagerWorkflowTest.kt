package com.pppp.moo.main.pager

import com.badoo.ribs.core.builder.BuildContext.Companion.root
import com.pppp.moo.main.pager.builder.PagerBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test

class PagerWorkflowTest {

    private lateinit var workflow: Pager

    @Before
    fun setup() {
        workflow = PagerBuilder(object : Pager.Dependency {

        }).build(
            buildContext = root(savedInstanceState = null),
            payload = PagerBuilder.Params(someField = 3)
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
        // val testObserver = TestObserver<Child>()

        // workflow.attachChild1().subscribe(testObserver)

        // testObserver.assertValueCount(1)
        // testObserver.assertComplete()

        throw RuntimeException("Add real tests.")
    }
}
