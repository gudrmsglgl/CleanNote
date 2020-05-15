package com.practice.cleannote.framework.presentation.notelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.practice.cleannote.R
import com.practice.cleannote.framework.presentation.common.BaseNoteFragment

const val NOTE_LIST_STATE_BUNDLE_KEY = "com.practice.cleannote.framework.presentation.notelist.state"

class NoteListFragment : BaseNoteFragment(R.layout.fragment_note_list) {

    override fun inject() {
        TODO("prepare dagger")
    }
}
