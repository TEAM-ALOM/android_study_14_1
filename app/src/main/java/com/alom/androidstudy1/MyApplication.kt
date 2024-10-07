package com.alom.androidstudy1

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class MyApplication : Application() {
    companion object {                  //  싱글톤
        val sharedPrefs: SharedPreferences by lazy {
            instance.getSharedPreferences("alom", Context.MODE_PRIVATE)
        }

        private lateinit var instance: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this          // application이 create되면 instance에 applicationContext를 넣어줌.
    }
}
