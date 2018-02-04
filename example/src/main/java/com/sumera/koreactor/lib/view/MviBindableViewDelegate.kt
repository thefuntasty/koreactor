package com.sumera.koreactor.lib.view

import com.sumera.koreactor.lib.reactor.data.MviEvent
import com.sumera.koreactor.lib.reactor.data.MviState
import io.reactivex.Observable

interface MviBindableViewDelegate<STATE : MviState> {

	fun bindToState(stateObservable: Observable<STATE>)

	fun bindToEvent(eventsObservable: Observable<MviEvent<STATE>>)

	fun unbindFromState()

	fun unbindFromEvents()

	fun unbindActions()
}
