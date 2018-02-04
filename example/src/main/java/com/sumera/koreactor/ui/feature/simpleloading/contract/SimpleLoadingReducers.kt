package com.sumera.koreactor.ui.feature.simpleloading.contract

import com.sumera.koreactorlib.reactor.data.MviStateReducer

sealed class SimpleLoadingReducer : MviStateReducer<SimpleLoadingState>

object ShowLoading : SimpleLoadingReducer() {
	override fun reduce(oldState: SimpleLoadingState): SimpleLoadingState {
		return oldState.copy(isLoading = true, isError = false, data = null)
	}
}

object ShowError : SimpleLoadingReducer() {
	override fun reduce(oldState: SimpleLoadingState): SimpleLoadingState {
		return oldState.copy(isLoading = false, isError = true, data = null)
	}
}

data class ShowData(val data: String) : SimpleLoadingReducer() {
	override fun reduce(oldState: SimpleLoadingState): SimpleLoadingState {
		return oldState.copy(isLoading = false, isError = false, data = data)
	}
}

