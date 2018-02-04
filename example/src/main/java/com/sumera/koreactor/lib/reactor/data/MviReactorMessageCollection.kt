package com.sumera.koreactor.lib.reactor.data

class MviReactorMessageCollection<STATE: MviState>(
        private val values: Collection<MviReactorMessage<STATE>>
) : MviReactorMessage<STATE> {

    override fun getMessages(): Collection<EventOrReducer<STATE>> {
        return values.flatMap { it.getMessages() }
    }
}
