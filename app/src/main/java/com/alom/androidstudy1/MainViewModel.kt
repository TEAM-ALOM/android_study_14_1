package com.alom.androidstudy1

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    private var _currentMemo = MutableStateFlow("")

    val currentMemo: StateFlow<String>
        get() = _currentMemo.asStateFlow()

    init {
        viewModelScope.launch {
            _currentMemo.emit(repository.getMemo())
        }
    }


    @SuppressLint("CommitPrefEdits")
    fun updateValue(input: String) {
        viewModelScope.launch {
            _currentMemo.emit(input)
            repository.setMemo(input)
        }
    }
}