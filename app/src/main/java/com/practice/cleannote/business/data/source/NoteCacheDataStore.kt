package com.practice.cleannote.business.data.source

import com.practice.cleannote.business.data.model.NoteEntity
import com.practice.cleannote.business.data.repository.NoteCache
import com.practice.cleannote.business.data.repository.NoteDataStore
import io.reactivex.Flowable
import javax.inject.Inject

open class NoteCacheDataStore
@Inject
constructor(private val noteCache: NoteCache): NoteDataStore{

    override fun getNumNotes(): Flowable<List<NoteEntity>> = noteCache.getNumNotes()

}