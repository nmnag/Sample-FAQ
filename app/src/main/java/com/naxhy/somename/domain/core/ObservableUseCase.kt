package com.naxhy.somename.domain.core

import io.reactivex.Observable


interface ObservableUseCase<T> {

    fun execute(): Observable<T>
}