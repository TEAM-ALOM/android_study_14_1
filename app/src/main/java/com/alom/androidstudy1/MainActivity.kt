package com.alom.androidstudy1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alom.androidstudy1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var memoViewModel: MemoViewModel
    private lateinit var binding : ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        memoViewModel = ViewModelProvider(this).get(MemoViewModel::class.java)

        val sharedPreferences = getSharedPreferences("memo", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        Log.d(TAG, sharedPreferences.getString("memo","").toString())
        val initData = sharedPreferences.getString("memo","").toString()

        binding.etMemo.setText(initData)
        Log.d(TAG+"textview", binding.etMemo.text.toString())

        lifecycleScope.launch{
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    memoViewModel.currentValue.collect{
                        editor.putString("memo",it)
                        editor.apply()
                    }
                }
            }
        }

        binding.btnSave.setOnClickListener {
            memoViewModel.saveMemo(binding.etMemo.text.toString())
        }
    }
}