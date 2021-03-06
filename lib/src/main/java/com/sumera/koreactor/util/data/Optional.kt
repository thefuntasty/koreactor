package com.sumera.koreactor.util.data

data class Optional<out T>(val value: T?) {

	val isNotNull: Boolean
		get() = value != null

	val isNull: Boolean
		get() = value == null
}

fun <T> T?.asOptional() = Optional(this)