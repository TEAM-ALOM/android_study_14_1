package com.alom.androidstudy1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.alom.androidstudy1.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var memoViewModel: MemoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        memoViewModel = ViewModelProvider(this)[MemoViewModel::class.java]

        binding.btnSave.setOnClickListener{
            memoViewModel.updateMemo(binding.etText.text.toString())
        }

        lifecycleScope.launch {
            memoViewModel.currentValue.collect{
                binding.etText.setText(it)
            }
        }
    }
}