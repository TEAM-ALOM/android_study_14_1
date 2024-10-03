package com.alom.androidstudy1.viewModel

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MemoViewModel: ViewModel() {

    private val _currentValue = MutableLiveData<String>()
    val currentValue : LiveData<String>
        get() = _currentValue



    fun saveMemo(context: Context, memo: String) {
        _currentValue.value = memo
        val sharedPreferences = context.getSharedPreferences("memo", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("memo", memo)
        editor.apply()


    }

}