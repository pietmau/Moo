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
import io.reactivex.Observable.just

internal class TabbedSwitcherFeature : ActorReducerFeature<Wish, Effect, State, News>(
    initialState = State("Initial state"),
    bootstrapper = BootStrapperImpl(),
    actor = ActorImpl(),
    reducer = ReducerImpl(),
    newsPublisher = NewsPublisherImpl()
) {

    data class State(
        val yourData: String
    )

    sealed class Wish {
        object Initial : Wish()
    }

    sealed class Effect {
        object Initial : Effect()
    }

    sealed class News

    class BootStrapperImpl : Bootstrapper<Wish> {
        override fun invoke(): Observable<Wish> {
            return just(Wish.Initial)
        }
    }

    class ActorImpl : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<Effect> {
            return just(Effect.Initial)
        }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State {
            return state.copy(state.yourData + " I ")
        }
    }

    class NewsPublisherImpl : NewsPublisher<Wish, Effect, State, News> {
        override fun invoke(wish: Wish, effect: Effect, state: State): News? =
            null
    }
}
