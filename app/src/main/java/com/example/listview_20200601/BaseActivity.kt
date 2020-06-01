package com.example.listview_20200601

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    val mContext = this
    abstract fun setupEvents()
    abstract fun setValues()

    //fun은 함수란 뜻임다

}