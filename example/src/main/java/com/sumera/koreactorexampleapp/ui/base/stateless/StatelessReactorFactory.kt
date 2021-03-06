package com.sumera.koreactorexampleapp.ui.base.stateless

import com.sumera.koreactorexampleapp.injection.PerActivity
import com.sumera.koreactor.reactor.MviReactorFactory
import javax.inject.Inject
import javax.inject.Provider

@PerActivity
class StatelessReactorFactory @Inject constructor(
        private val reactorProvider: Provider<StatelessReactor>
) : MviReactorFactory<StatelessReactor>() {

    override val reactor: StatelessReactor
        get() = reactorProvider.get()
}
