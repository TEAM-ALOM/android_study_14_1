package com.alom.androidstudy1

import android.content.SharedPreferences

class RepositoryImpl(private val sharedPreference: SharedPreferences): MemoRepository {
    override suspend fun getMemo(): String {
        return sharedPreference.getString("memo", "").toString()
    }

    override suspend fun setMemo(input: String) {
        sharedPreference.edit().putString("memo", input).apply()
    }
}