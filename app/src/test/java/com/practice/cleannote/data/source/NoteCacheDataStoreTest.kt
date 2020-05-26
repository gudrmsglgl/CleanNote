package com.practice.cleannote.data.source

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.practice.cleannote.business.data.model.NoteEntity
import com.practice.cleannote.business.data.repository.NoteCache
import com.practice.cleannote.business.data.source.NoteCacheDataStore
import com.practice.cleannote.data.test.factory.NoteFactory
import io.reactivex.Flowable
import io.reactivex.observers.TestObserver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NoteCacheDataStoreTest {

    private lateinit var noteCacheDataStore: NoteCacheDataStore
    private lateinit var noteCache: NoteCache

    @BeforeEach
    fun setUp() {
        noteCache = mock{
            on { getNumNotes() } doReturn Flowable.just(NoteFactory.createNoteEntityList(10))
        }
        noteCacheDataStore = NoteCacheDataStore(noteCache)
    }

    @Test
    fun getNumNotesCompletes() {
        val testObserver = noteCacheDataStore.getNumNotes().test()
        verify(noteCache).getNumNotes()
        testObserver.assertComplete()
    }
}