package com.alom.androidstudy1

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MemoViewModel : ViewModel(){
    val _currentText = MutableStateFlow<String>("")
    val currentText:StateFlow<String> = _currentText

    fun returnMemo(context: Context){
        val pref:SharedPreferences = context.getSharedPreferences("pref",Context.MODE_PRIVATE)
        _currentText.value = pref.getString("content","")!!
    }

    fun saveMemo(content:String,context: Context){
        _currentText.value = content

        val pref:SharedPreferences = context.getSharedPreferences("pref",Context.MODE_PRIVATE)
        pref.edit().putString("content",content).apply()

        Toast.makeText(context,"메모가 저장되었습니다",Toast.LENGTH_LONG).show()
    }
}