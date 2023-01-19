package com.hse.sleeppro.base
interface EventHandler<T> {
    fun obtainEvent(event: T)
}