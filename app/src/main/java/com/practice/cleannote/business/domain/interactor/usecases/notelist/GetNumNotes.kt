package com.practice.cleannote.business.domain.interactor.usecases.notelist

import com.practice.cleannote.business.domain.interactor.FlowableUseCase
import com.practice.cleannote.business.domain.interactor.executor.PostExecutionThread
import com.practice.cleannote.business.domain.interactor.executor.ThreadExecutor
import com.practice.cleannote.business.domain.interactor.repository.NoteRepository
import com.practice.cleannote.business.domain.model.Note
import io.reactivex.Flowable
import javax.inject.Inject

open class GetNumNotes
@Inject
constructor(
    val repository: NoteRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
): FlowableUseCase<List<Note>, Void?>(threadExecutor, postExecutionThread){

    public override fun buildUseCaseObservable(
        params: Void?
    ): Flowable<List<Note>> = repository.getNumNotes()

}