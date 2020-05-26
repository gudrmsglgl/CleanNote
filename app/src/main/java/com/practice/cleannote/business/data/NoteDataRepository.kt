package com.practice.cleannote.business.data

import com.practice.cleannote.business.data.mapper.NoteMapper
import com.practice.cleannote.business.data.source.NoteDataStoreFactory
import com.practice.cleannote.business.domain.interactor.repository.NoteRepository
import com.practice.cleannote.business.domain.model.Note
import io.reactivex.Flowable
import javax.inject.Inject

class NoteDataRepository
@Inject
constructor(
    private val factory: NoteDataStoreFactory,
    private val noteMapper: NoteMapper
): NoteRepository {

    override fun getNumNotes(): Flowable<List<Note>> =
        factory.retrieveRemoteDataStore().getNumNotes().map { noteEntities ->
            noteEntities.map { noteMapper.mapFromEntity(it) }
        }

}