package com.alom.androidstudy1

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: Repository): ViewModel() {
    private var _currentMemo = MutableStateFlow("")

    val currentMemo: StateFlow<String>
        get() = _currentMemo.asStateFlow()

    init {

        viewModelScope.launch {
            val memo = withContext(Dispatchers.IO) {
                repository.getMemo()
            }
            _currentMemo.emit(memo)
        }
    }


    @SuppressLint("CommitPrefEdits")
    fun updateValue(input: String) {
        viewModelScope.launch {
            _currentMemo.emit(input)
            withContext(Dispatchers.IO) {
                repository.setMemo(input)
            }
        }
    }
}