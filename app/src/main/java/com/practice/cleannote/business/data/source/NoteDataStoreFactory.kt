package com.practice.cleannote.business.data.source

import com.practice.cleannote.business.data.repository.NoteCache
import com.practice.cleannote.business.data.repository.NoteDataStore
import javax.inject.Inject

open class NoteDataStoreFactory
@Inject
constructor(
    private val noteCache: NoteCache,
    private val noteCacheDataStore: NoteCacheDataStore,
    private val noteRemoteDataStore: NoteRemoteDataStore
){

    open fun retrieveCacheDataStore(): NoteCacheDataStore = noteCacheDataStore
    open fun retrieveRemoteDataStore(): NoteDataStore = noteRemoteDataStore
}