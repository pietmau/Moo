package com.pppp.moo.main.tabbed_switcher.feature

import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.Bootstrapper
import com.badoo.mvicore.element.NewsPublisher
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ActorReducerFeature
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature.Effect
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature.News
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature.State
import com.pppp.moo.main.tabbed_switcher.feature.TabbedSwitcherFeature.Wish
import io.reactivex.Observable
import io.reactivex.Observable.empty

internal class TabbedSwitcherFeature : ActorReducerFeature<Wish, Effect, State, News>(
    initialState = State(),
    bootstrapper = BootStrapperImpl(),
    actor = ActorImpl(),
    reducer = ReducerImpl(),
    newsPublisher = NewsPublisherImpl()
) {

    data class State(
        val yourData: Any? = null
    )

    sealed class Wish

    sealed class Effect

    sealed class News

    class BootStrapperImpl : Bootstrapper<Wish> {
        override fun invoke(): Observable<Wish> =
            empty()
    }

    class ActorImpl : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<Effect> =
            empty()
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State =
            state
    }

    class NewsPublisherImpl : NewsPublisher<Wish, Effect, State, News> {
        override fun invoke(wish: Wish, effect: Effect, state: State): News? =
            null
    }
}
