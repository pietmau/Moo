package com.pppp.moo.main.pager

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.customisation.inflate
import com.pppp.moo.main.pager.PagerView.Event
import com.pppp.moo.main.pager.PagerView.ViewModel
import com.jakewharton.rxrelay2.PublishRelay
import com.pppp.moo.R
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

interface PagerView : RibView,
    ObservableSource<Event>,
    Consumer<ViewModel> {

    sealed class Event

    data class ViewModel(
        val i: Int = 0
    )

    interface Factory : ViewFactory<Nothing?, PagerView>
}

class PagerViewImpl private constructor(
    override val androidView: ViewGroup,
    private val events: PublishRelay<Event> = PublishRelay.create()
) : PagerView,
    ObservableSource<Event> by events,
    Consumer<ViewModel> {

    class Factory(
        @LayoutRes private val layoutRes: Int = R.layout.rib_pager
    ) : PagerView.Factory {
        override fun invoke(deps: Nothing?): (ViewGroup) -> PagerView = {
            PagerViewImpl(
                inflate(it, layoutRes)
            )
        }
    }

    override fun accept(vm: PagerView.ViewModel) {
    }
}
