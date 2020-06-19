package com.pppp.moo.main.tabs.feature

import android.os.Parcelable
import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.Bootstrapper
import com.badoo.mvicore.element.NewsPublisher
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.element.TimeCapsule
import com.badoo.mvicore.feature.ActorReducerFeature
import com.pppp.moo.main.tabs.feature.TabsFeature.Effect
import com.pppp.moo.main.tabs.feature.TabsFeature.News
import com.pppp.moo.main.tabs.feature.TabsFeature.State
import com.pppp.moo.main.tabs.feature.TabsFeature.Wish
import io.reactivex.Observable
import io.reactivex.Observable.empty
import io.reactivex.Observable.just
import kotlinx.android.parcel.Parcelize

internal class TabsFeature(timeCapsule: TimeCapsule<Parcelable>) : ActorReducerFeature<Wish, Effect, State, News>(
    initialState = State("intilial styate"),
    bootstrapper = BootStrapperImpl(),
    actor = ActorImpl(),
    reducer = ReducerImpl(),
    newsPublisher = NewsPublisherImpl()
) {

    @Parcelize
    data class State(
        val yourData: String = ""
    ) : Parcelable

    sealed class Wish {
        object Initial : Wish()
        object Bar : Wish()
        object Foo : Wish()
    }

    data class Effect(val data: String = "")

    sealed class News

    class BootStrapperImpl : Bootstrapper<Wish> {
        override fun invoke(): Observable<Wish> {
            return just(Wish.Initial)
        }
    }

    class ActorImpl : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<Effect> {
            return just(Effect("foo"))
        }

    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State {
            return state.copy(state.yourData + effect.data)
        }
    }

    class NewsPublisherImpl : NewsPublisher<Wish, Effect, State, News> {
        override fun invoke(wish: Wish, effect: Effect, state: State): News? =
            null
    }
}
