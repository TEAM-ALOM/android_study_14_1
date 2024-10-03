package com.alom.androidstudy1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alom.androidstudy1.databinding.ActivityMainBinding
import com.alom.androidstudy1.viewModel.MemoViewModel

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

        Log.d(TAG, sharedPreferences.getString("memo","").toString())
        val initData = sharedPreferences.getString("memo","").toString()
        binding.etMemo.setText(initData)
        Log.d(TAG+"textview", binding.etMemo.text.toString())

        memoViewModel.currentValue.observe(this, Observer {
            binding.etMemo.setText(it.toString())
        })
        val btnSave = binding.btnSave
        btnSave.setOnClickListener {
            memoViewModel.saveMemo(this,binding.etMemo.text.toString())
        }
    }
}