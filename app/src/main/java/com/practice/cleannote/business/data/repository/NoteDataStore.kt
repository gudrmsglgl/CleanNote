package com.practice.cleannote.business.data.repository

import com.practice.cleannote.business.data.model.NoteEntity
import io.reactivex.Flowable

interface NoteDataStore {
    fun getNumNotes(): Flowable<List<NoteEntity>>
}