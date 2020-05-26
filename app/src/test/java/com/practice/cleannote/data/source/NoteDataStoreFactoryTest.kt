package com.practice.cleannote.data.source

import com.nhaarman.mockitokotlin2.mock
import com.practice.cleannote.business.data.repository.NoteCache
import com.practice.cleannote.business.data.source.NoteCacheDataStore
import com.practice.cleannote.business.data.source.NoteDataStoreFactory
import com.practice.cleannote.business.data.source.NoteRemoteDataStore
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NoteDataStoreFactoryTest {

    private lateinit var noteDataStoreFactory: NoteDataStoreFactory

    private lateinit var noteCache: NoteCache
    private lateinit var noteCacheDataStore: NoteCacheDataStore
    private lateinit var noteRemoteDataStore: NoteRemoteDataStore

    @BeforeEach
    fun setUp(){
        noteCache = mock()
        noteCacheDataStore = mock()
        noteRemoteDataStore = mock()
        noteDataStoreFactory = NoteDataStoreFactory(noteCache, noteCacheDataStore, noteRemoteDataStore)
    }

    @Test
    fun retrieveCacheDataStoreReturnsCacheDataStore() {
        val noteCacheDataStore = noteDataStoreFactory.retrieveCacheDataStore()
        assertThat(noteCacheDataStore, instanceOf(NoteCacheDataStore::class.java))
    }

    @Test
    fun retrieveRemoteDataStoreReturnsRemoteDataStore(){
        val remoteDataStore = noteDataStoreFactory.retrieveRemoteDataStore()
        assertThat(remoteDataStore, instanceOf(NoteRemoteDataStore::class.java))
    }
}