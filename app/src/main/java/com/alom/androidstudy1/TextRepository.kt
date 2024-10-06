package com.alom.androidstudy1

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.renderscript.ScriptGroup.Input
import androidx.datastore.core.DataStore
import java.util.prefs.Preferences


class TextRepository(context: Context) {
    val sharedPreferences = context.getSharedPreferences("alom", MODE_PRIVATE)
    fun saveValue(input: String)
    { val editor = sharedPreferences.edit()
    editor.putString("text",input)
    editor.apply()}
    fun getValue():String{
        return sharedPreferences.getString("text","")?:""
    }
//    private val dataStore: DataStore<Preferences> = context.createDataStore()
}