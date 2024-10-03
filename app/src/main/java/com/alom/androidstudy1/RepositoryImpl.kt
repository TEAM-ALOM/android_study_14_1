package com.alom.androidstudy1

import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow

class RepositoryImpl(private val sharedPreference: SharedPreferences): Repository {
    override suspend fun getMemo(): String {
        return sharedPreference.getString("memo", "").toString()
    }

    override suspend fun setMemo(input: String) {
        sharedPreference.edit().putString("memo", input).apply()
    }
}