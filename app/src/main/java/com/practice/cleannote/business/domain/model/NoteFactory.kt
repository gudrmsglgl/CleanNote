package com.practice.cleannote.business.domain.model

import com.practice.cleannote.business.domain.util.DateUtil
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteFactory
@Inject
constructor(
    private val dateUtil: DateUtil
){

    fun createSingleNote(
        id: String? = null,
        title: String,
        body: String? = null
    ): Note = Note(
        id = id ?: UUID.randomUUID().toString(),
        title = title,
        body = body ?: "",
        created_at = dateUtil.getCurrentTimestamp(),
        updated_at = dateUtil.getCurrentTimestamp()
    )

    fun createNoteList(numNotes: Int): List<Note> = (0 until numNotes)
        .map {
            createSingleNote(
                id = UUID.randomUUID().toString(),
                title = UUID.randomUUID().toString(),
                body = UUID.randomUUID().toString()
            )}
        .toList()

}