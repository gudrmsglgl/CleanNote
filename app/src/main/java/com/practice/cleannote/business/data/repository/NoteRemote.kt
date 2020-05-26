package com.practice.cleannote.business.data.repository

import com.practice.cleannote.business.data.model.NoteEntity
import io.reactivex.Flowable

interface NoteRemote {

    fun getNumNotes(): Flowable<List<NoteEntity>>
}