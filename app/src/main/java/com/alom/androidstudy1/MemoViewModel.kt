package com.alom.androidstudy1

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MemoViewModel(context: Context) : ViewModel() {

    private val preferenceUtil = PreferenceUtil(context)
    private val _currentValue = MutableLiveData<String>()

    val currentValue: LiveData<String>
        get() = _currentValue

    fun updateMemo(newMemo: String) {
        _currentValue.value = newMemo
        preferenceUtil.setString("memo", newMemo)
    }
}