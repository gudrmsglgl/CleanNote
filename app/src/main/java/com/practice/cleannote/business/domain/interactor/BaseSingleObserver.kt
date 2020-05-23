package com.practice.cleannote.business.domain.interactor

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

open class BaseSingleObserver<T>: SingleObserver<T> {
    override fun onSuccess(t: T) {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onError(e: Throwable) {

    }
}