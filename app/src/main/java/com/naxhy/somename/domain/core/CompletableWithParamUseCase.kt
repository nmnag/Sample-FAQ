package com.naxhy.somename.domain.core

import io.reactivex.Completable


interface CompletableWithParamUseCase<in T> {

    fun execute(t: T): Completable
}