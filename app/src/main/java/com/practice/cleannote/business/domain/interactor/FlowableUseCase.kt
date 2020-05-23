package com.practice.cleannote.business.domain.interactor

import com.practice.cleannote.business.domain.interactor.executor.PostExecutionThread
import com.practice.cleannote.business.domain.interactor.executor.ThreadExecutor
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

abstract class FlowableUseCase<T, in Params> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
){

    private val disposables = CompositeDisposable()

    protected abstract fun buildUseCaseObservable(
        params: Params? = null
    ): Flowable<T>

    open fun execute(observer: DisposableSubscriber<T>, params: Params? = null) {
        val observable = this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler) as Flowable<T>
        addDisposable(observable.subscribeWith(observer))
    }

    private fun addDisposable(disposable: Disposable) = disposables.add(disposable)

    fun dispose(){
        if (!disposables.isDisposed) disposables.dispose()
    }
}