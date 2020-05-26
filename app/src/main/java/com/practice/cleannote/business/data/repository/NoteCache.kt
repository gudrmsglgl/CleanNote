package com.practice.cleannote.business.data.repository

import com.practice.cleannote.business.data.model.NoteEntity
import io.reactivex.Flowable

interface NoteCache {
    fun getNumNotes(): Flowable<List<NoteEntity>>
}