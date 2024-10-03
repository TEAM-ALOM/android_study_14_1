package com.alom.androidstudy1

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val sharedPreference: SharedPreferences): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(sharedPreference) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}