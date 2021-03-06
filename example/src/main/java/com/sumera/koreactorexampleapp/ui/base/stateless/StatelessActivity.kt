package com.sumera.koreactorexampleapp.ui.base.stateless

import com.sumera.koreactor.reactor.MviReactor
import com.sumera.koreactorexampleapp.ui.base.BaseActivity
import javax.inject.Inject

abstract class StatelessActivity: BaseActivity<EmptyState>() {

    @Inject lateinit var reactorFactory: StatelessReactorFactory

    override fun createReactor(): MviReactor<EmptyState> {
        return getReactor(reactorFactory, StatelessReactor::class.java)
    }
}
