package com.alom.androidstudy1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MemoRepository): ViewModel() {
    private var _currentMemo = MutableStateFlow("")

    val currentMemo: StateFlow<String>
        get() = _currentMemo.asStateFlow()

    init {              // 뷰모델이 실행될때 싫행
        viewModelScope.launch {
            val memo = withContext(Dispatchers.IO) {                // Dispatchers.IO로 비동기적 실행
                repository.getMemo()
            }
            _currentMemo.emit(memo)             // 불러온 데이터 emit
        }
    }

    fun updateValue(input: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.setMemo(input)
            }
            _currentMemo.emit(input)
        }
    }
}


/*
레포지토리 & ViewModelFactory 미사용

class MainViewModel(private val getSharedPreferences: SharedPreferences) : ViewModel() {

    private val _currentMemo = MutableStateFlow("")
    val currentMemo: StateFlow<String>
        get() = _currentMemo.asStateFlow()

    init {
        viewModelScope.launch {
            val memo = withContext(Dispatchers.IO) {
                sharedPreferences.getString("memo", "").orEmpty()
            }
            _currentMemo.emit(memo)
        }
    }

    fun updateValue(input: String) {
        viewModelScope.launch {
            _currentMemo.emit(input)
            withContext(Dispatchers.IO) {
                sharedPreferences.edit().putString("memo", input).apply()
            }
        }
    }
}


*/