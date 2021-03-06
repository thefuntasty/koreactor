package com.sumera.koreactorexampleapp.ui.feature.main

import android.content.Intent
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import com.sumera.koreactorexampleapp.R
import com.sumera.koreactor.reactor.MviReactor
import com.sumera.koreactor.reactor.data.MviEvent
import com.sumera.koreactorexampleapp.ui.base.BaseActivity
import com.sumera.koreactorexampleapp.ui.feature.counter.CounterActivity
import com.sumera.koreactorexampleapp.ui.feature.infinity.InfinityActivity
import com.sumera.koreactorexampleapp.ui.feature.main.contract.MainState
import com.sumera.koreactorexampleapp.ui.feature.main.contract.NavigateToCounterEvent
import com.sumera.koreactorexampleapp.ui.feature.main.contract.NavigateToInfinityEvent
import com.sumera.koreactorexampleapp.ui.feature.main.contract.NavigateToSimpleLoadingEvent
import com.sumera.koreactorexampleapp.ui.feature.main.contract.NavigateToTimerEvent
import com.sumera.koreactorexampleapp.ui.feature.main.contract.NavigateToToDoEvent
import com.sumera.koreactorexampleapp.ui.feature.main.contract.OnCounterButtonCLickAction
import com.sumera.koreactorexampleapp.ui.feature.main.contract.OnInfinityButtonClickAction
import com.sumera.koreactorexampleapp.ui.feature.main.contract.OnSimpleLoadingButtonClickAction
import com.sumera.koreactorexampleapp.ui.feature.main.contract.OnTimerButtonClickAction
import com.sumera.koreactorexampleapp.ui.feature.main.contract.OnToDoButtonClickAction
import com.sumera.koreactorexampleapp.ui.feature.simpleloading.SimpleLoadingActivity
import com.sumera.koreactorexampleapp.ui.feature.timer.activity.TimerActivity
import com.sumera.koreactorexampleapp.ui.feature.todo.ToDoActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainState>() {

	@Inject lateinit var reactorFactory: MainReactorFactory

	override val layoutRes: Int
		get() = R.layout.activity_main

	override fun createReactor(): MviReactor<MainState> {
		return getReactor(reactorFactory, MainReactor::class.java)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		main_infinity.clicks()
				.map { OnInfinityButtonClickAction }
				.bindToReactor()

		main_todo.clicks()
				.map { OnToDoButtonClickAction }
				.bindToReactor()

		main_counter.clicks()
				.map { OnCounterButtonCLickAction }
				.bindToReactor()

		main_simpleLoading.clicks()
				.map { OnSimpleLoadingButtonClickAction }
				.bindToReactor()

		main_simpleTimer.clicks()
				.map { OnTimerButtonClickAction }
				.bindToReactor()
	}

	override fun bindToEvent(eventsObservable: Observable<MviEvent<MainState>>) {
		eventsObservable.observeEvent { event ->
			when (event) {
				is NavigateToInfinityEvent -> startActivity(Intent(this, InfinityActivity::class.java))
				is NavigateToCounterEvent -> startActivity(Intent(this, CounterActivity::class.java))
				is NavigateToToDoEvent -> startActivity(Intent(this, ToDoActivity::class.java))
				is NavigateToSimpleLoadingEvent -> startActivity(Intent(this, SimpleLoadingActivity::class.java))
				is NavigateToTimerEvent -> startActivity(Intent(this, TimerActivity::class.java))
			}
		}
	}
}
