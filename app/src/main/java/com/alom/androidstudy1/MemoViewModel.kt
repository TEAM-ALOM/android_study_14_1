package com.alom.androidstudy1
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MemoViewModel: ViewModel() {

    private val _currentValue = MutableStateFlow<String>("")
    val currentValue : StateFlow<String>
        get() = _currentValue

    fun saveMemo(memo: String) {
        viewModelScope.launch {
            _currentValue.emit(memo)
        }
    }
}