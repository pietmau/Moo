package com.pppp.moo.main.tabbed_switcher

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.customisation.inflate
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherView.Event
import com.pppp.moo.main.tabbed_switcher.TabbedSwitcherView.ViewModel
import com.jakewharton.rxrelay2.PublishRelay
import com.pppp.moo.R
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

interface TabbedSwitcherView : RibView,
    ObservableSource<Event>,
    Consumer<ViewModel> {

    sealed class Event

    data class ViewModel(
        val i: Int = 0
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

    override fun accept(vm: TabbedSwitcherView.ViewModel) {
    }
}
