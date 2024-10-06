package com.alom.androidstudy1

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MemoViewModel(context: Context) : ViewModel() {

    private val preferenceUtil = PreferenceUtil(context)
    private val _currentValue = MutableStateFlow<String>("")

    val currentValue: StateFlow<String> = _currentValue

    fun updateMemo(newMemo: String) {
        _currentValue.value = newMemo
        preferenceUtil.setString("memo", newMemo)
    }
}