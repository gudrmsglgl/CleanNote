package com.practice.cleannote.business.data.mapper

import com.practice.cleannote.business.data.model.NoteEntity
import com.practice.cleannote.business.domain.model.Note
import javax.inject.Inject

open class NoteMapper @Inject constructor(): Mapper<NoteEntity, Note> {

    override fun mapFromEntity(type: NoteEntity): Note = Note(
        type.id,
        type.title,
        type.body,
        type.updated_at,
        type.created_at
    )

    override fun mapToEntity(type: Note): NoteEntity = NoteEntity(
        type.id,
        type.title,
        type.body,
        type.updated_at,
        type.created_at
    )
}