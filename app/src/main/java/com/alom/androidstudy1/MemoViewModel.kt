package com.alom.androidstudy1

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MemoViewModel(application: Application) : AndroidViewModel(application) {

    private val preferenceUtil = PreferenceUtil(getApplication<Application>().applicationContext)
    private val _currentValue = MutableStateFlow<String>("")

    val currentValue: StateFlow<String> = _currentValue

    init{
        _currentValue.value = preferenceUtil.getString("memo", "")
    }

    fun updateMemo(newMemo: String) {
        _currentValue.value = newMemo
        preferenceUtil.setString("memo", newMemo)
    }
}