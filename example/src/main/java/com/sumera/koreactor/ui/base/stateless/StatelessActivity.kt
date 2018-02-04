package com.sumera.koreactor.ui.base.stateless

import com.sumera.koreactorlib.reactor.MviReactor
import com.sumera.koreactor.ui.base.BaseActivity
import javax.inject.Inject

abstract class StatelessActivity: BaseActivity<EmptyState>() {

    @Inject lateinit var reactorFactory: StatelessReactorFactory

    override fun createReactor(): MviReactor<EmptyState> {
        return getReactor(reactorFactory, StatelessReactor::class.java)
    }
}
