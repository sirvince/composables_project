package com.example.composableproject.util.helper

import android.util.Log

class LoggerUtil {



    fun logger( className : String, message : String ){
        Log.v("mLOG $className" , "message $message")
    }
}