package com.practice.cleannote.business.domain.interactor.repository

import com.practice.cleannote.business.domain.model.Note
import io.reactivex.Flowable

interface NoteRepository {

    fun getNumNotes(): Flowable<List<Note>>

}