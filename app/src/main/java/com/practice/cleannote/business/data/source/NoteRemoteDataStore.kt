package com.practice.cleannote.business.data.source

import com.practice.cleannote.business.data.model.NoteEntity
import com.practice.cleannote.business.data.repository.NoteDataStore
import com.practice.cleannote.business.data.repository.NoteRemote
import io.reactivex.Flowable
import javax.inject.Inject

open class NoteRemoteDataStore
@Inject constructor(private val noteRemote: NoteRemote): NoteDataStore{

    override fun getNumNotes(): Flowable<List<NoteEntity>> = noteRemote.getNumNotes()

}