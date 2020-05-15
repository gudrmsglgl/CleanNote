package com.practice.cleannote.util

import android.util.Log
import com.practice.cleannote.util.Constants.DEBUG
import com.practice.cleannote.util.Constants.TAG

var isUnitTest = false

fun printLogD(className: String?, message: String ) {
    if (DEBUG && !isUnitTest) {
        Log.d(TAG, "$className: $message")
    }
    else if(DEBUG && isUnitTest){
        println("$className: $message")
    }
}