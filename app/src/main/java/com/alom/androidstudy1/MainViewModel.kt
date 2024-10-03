package com.alom.androidstudy1

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val sharedPreference: SharedPreferences): ViewModel() {
    private var _currentMemo = MutableStateFlow("")

    val currentMemo: StateFlow<String>
        get() = _currentMemo.asStateFlow()

    init {
        _currentMemo = MutableStateFlow(sharedPreference.getString("memo", "").toString())
    }


    @SuppressLint("CommitPrefEdits")
    fun updateValue(input: String) {
        viewModelScope.launch {
            _currentMemo.emit(input)
            sharedPreference.edit().putString("memo", input).apply()
        }
    }
}