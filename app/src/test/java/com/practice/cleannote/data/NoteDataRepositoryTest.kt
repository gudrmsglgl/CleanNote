package com.practice.cleannote.data

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.practice.cleannote.business.data.NoteDataRepository
import com.practice.cleannote.business.data.mapper.NoteMapper
import com.practice.cleannote.business.data.model.NoteEntity
import com.practice.cleannote.business.data.source.NoteDataStoreFactory
import com.practice.cleannote.business.data.source.NoteRemoteDataStore
import com.practice.cleannote.business.domain.model.Note
import com.practice.cleannote.data.test.factory.NoteFactory
import io.reactivex.Flowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NoteDataRepositoryTest {

    private lateinit var noteDataRepository: NoteDataRepository

    private lateinit var noteDataStoreFactory: NoteDataStoreFactory
    private lateinit var noteMapper: NoteMapper

    private lateinit var noteRemoteDataStore: NoteRemoteDataStore
    private lateinit var noteEntities: List<NoteEntity>

    @BeforeEach
    fun setUp(){

        noteMapper = mock()
        noteEntities = NoteFactory.createNoteEntityList(10)
        noteRemoteDataStore = mock{
            on { getNumNotes() }.doReturn(Flowable.just(noteEntities))
        }
        noteDataStoreFactory = mock{
            on { retrieveRemoteDataStore() }.doReturn(noteRemoteDataStore)
        }
        noteDataRepository = NoteDataRepository(noteDataStoreFactory, noteMapper)
    }

    @Test
    fun getNumNoteComplete(){
        val notes: List<Note> = NoteFactory.createNoteList(10)
        // note 를 기준으로 잡고 assert 로 확인 가능 맵핑 됬는 지
        notes.forEachIndexed { index, note ->
            whenever(noteMapper.mapFromEntity(noteEntities[index])).thenReturn(note)
        }
        val testObserver = noteDataRepository.getNumNotes().test()
        testObserver.assertComplete()
        testObserver.assertValue(notes)
    }

}