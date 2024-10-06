package com.alom.androidstudy1

import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TextViewModel(
    private val textRepository: TextRepository
): ViewModel() {


//    private val _currentUserInput = MutableStateFlow<String>("")
//    val currentUserInput: StateFlow<String> = _currentUserInput
    private val _currentValue = MutableStateFlow<String>("")
    val currentValue: StateFlow<String> = _currentValue
    init{
        val savedText = textRepository.getValue()
        _currentValue.value =savedText.toString()
    }

     fun updateValue(input: String){
        viewModelScope.launch {
            textRepository.saveValue(input)
            _currentValue.value = input
        }
    }


}