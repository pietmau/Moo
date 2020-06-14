package com.pppp.moo.main.tabs

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.customisation.inflate
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pppp.moo.main.tabs.TabsView.Event
import com.pppp.moo.main.tabs.TabsView.ViewModel
import com.jakewharton.rxrelay2.PublishRelay
import com.pppp.moo.R
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

interface TabsView : RibView,
    ObservableSource<Event>,
    Consumer<ViewModel> {

    sealed class Event

    data class ViewModel(
        val i: Int = 0
    )

    interface Factory : ViewFactory<Nothing?, TabsView>
}

class TabsViewImpl private constructor(
    override val androidView: ViewGroup,
    private val events: PublishRelay<Event> = PublishRelay.create()
) : TabsView,
    ObservableSource<Event> by events,
    Consumer<ViewModel> {

    class Factory(
        @LayoutRes private val layoutRes: Int = R.layout.rib_tabs
    ) : TabsView.Factory {
        override fun invoke(deps: Nothing?): (ViewGroup) -> TabsView = {
            TabsViewImpl(
                inflate(it, layoutRes)
            )
        }
    }

    init {
        androidView.findViewById<BottomNavigationView>(R.id.bottom_nav).setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
            }
        }
    }

    override fun accept(vm: TabsView.ViewModel) {
    }
}
