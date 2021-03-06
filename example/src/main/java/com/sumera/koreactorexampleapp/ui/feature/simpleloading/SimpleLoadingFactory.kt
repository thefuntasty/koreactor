package com.sumera.koreactorexampleapp.ui.feature.simpleloading

import com.sumera.koreactor.reactor.MviReactorFactory
import com.sumera.koreactorexampleapp.injection.PerActivity
import javax.inject.Inject
import javax.inject.Provider

@PerActivity
class SimpleLoadingReactorFactory @Inject constructor(
        private val reactorProvider: Provider<SimpleLoadingReactor>
) : MviReactorFactory<SimpleLoadingReactor>() {

    override val reactor: SimpleLoadingReactor
        get() = reactorProvider.get()
}
