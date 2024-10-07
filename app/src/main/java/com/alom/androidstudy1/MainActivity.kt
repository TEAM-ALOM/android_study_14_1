package com.alom.androidstudy1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alom.androidstudy1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = MyApplication.sharedPrefs

        val repository = RepositoryImpl(sharedPreference)
        val factory = ViewModelFactory(repository)

        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
//      mainViewModel = MainViewModel(MyApplication.sharedPrefs)                       레포지토리 & ViewModelFactory 미사용의 경우

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.currentMemo.collect { memo ->
                    if (binding.etMemo.text.toString() != memo) {       // 지금 떠있는 텍스트와 같으면 굳이 중복으로
                        binding.etMemo.setText(memo)
                    }
                }
            }
        }

        binding.btnSave.setOnClickListener {
            val newMemo = binding.etMemo.text.toString().trim()
            if (newMemo.isEmpty()) {
                Toast.makeText(this, "저장할 메모를 입력해 주세요", Toast.LENGTH_SHORT).show()
            } else {
                mainViewModel.updateValue(newMemo)
                Toast.makeText(this, "저장됨", Toast.LENGTH_SHORT).show()
            }
        }
    }
}