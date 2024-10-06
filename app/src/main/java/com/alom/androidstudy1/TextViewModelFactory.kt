package com.alom.androidstudy1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class TextViewModelFactory(
    private val repository: TextRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TextViewModel::class.java)) {
            return TextViewModel(repository) as T
        } else {
            throw IllegalArgumentException()
        }

    }
}