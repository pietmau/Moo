package com.pppp.moo.main.tabbed_switcher

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.badoo.ribs.core.Node
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.customisation.inflate
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherView.Event
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherView.ViewModel
import com.jakewharton.rxrelay2.PublishRelay
import com.pppp.moo.R
import com.pppp.moo.main.pager.Pager
import com.pppp.moo.main.tabs.Tabs
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import java.lang.UnsupportedOperationException

interface TabbedSwitcherView : RibView,
    ObservableSource<Event>,
    Consumer<ViewModel> {

    sealed class Event

    data class ViewModel(
        val i: String = ""
    )

    interface Factory : ViewFactory<Nothing?, TabbedSwitcherView>
}

class TabbedSwitcherViewImpl private constructor(
    override val androidView: ViewGroup,
    private val events: PublishRelay<Event> = PublishRelay.create()
) : TabbedSwitcherView,
    ObservableSource<Event> by events,
    Consumer<ViewModel> {

    class Factory(
        @LayoutRes private val layoutRes: Int = R.layout.rib_tabbed_switcher
    ) : TabbedSwitcherView.Factory {
        override fun invoke(deps: Nothing?): (ViewGroup) -> TabbedSwitcherView = {
            TabbedSwitcherViewImpl(
                inflate(it, layoutRes)
            )
        }
    }

    private val content: ViewGroup = androidView.findViewById(R.id.content)
    private val tabs: ViewGroup = androidView.findViewById(R.id.tabs)

    override fun getParentViewForChild(child: Node<*>): ViewGroup? =
        when (child) {
            is Pager -> content
            is Tabs -> tabs
            else -> throw UnsupportedOperationException("Unknown child or Rib")
        }

    override fun accept(vm: TabbedSwitcherView.ViewModel) {
    }
}
