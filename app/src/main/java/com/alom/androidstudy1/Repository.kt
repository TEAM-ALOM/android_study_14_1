package com.alom.androidstudy1

import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow

interface Repository {
    suspend fun getMemo(): String
    suspend fun setMemo(input: String)
}