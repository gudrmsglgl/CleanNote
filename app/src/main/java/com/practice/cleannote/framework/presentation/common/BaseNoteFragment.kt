package com.practice.cleannote.framework.presentation.common

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


abstract class BaseNoteFragment
constructor(
    private @LayoutRes val layoutRes: Int
): Fragment(layoutRes) {

    abstract fun inject()

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

}