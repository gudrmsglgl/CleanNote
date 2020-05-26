package com.practice.cleannote.data.source

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.practice.cleannote.business.data.repository.NoteRemote
import com.practice.cleannote.business.data.source.NoteRemoteDataStore
import com.practice.cleannote.data.test.factory.NoteFactory
import io.reactivex.Flowable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NoteRemoteDataStoreTest {

    private lateinit var noteRemote: NoteRemote
    private lateinit var noteRemoteDataStore: NoteRemoteDataStore

    @BeforeEach
    fun setUp(){
        noteRemote = mock{
            on { getNumNotes() }.doReturn(Flowable.just(NoteFactory.createNoteEntityList(10)))
        }
        noteRemoteDataStore = NoteRemoteDataStore(noteRemote)
    }

    @Test
    fun getNumNotesCompletes(){
        val testObserver = noteRemoteDataStore.getNumNotes().test()
        verify(noteRemote).getNumNotes()
        testObserver.assertComplete()
    }
}