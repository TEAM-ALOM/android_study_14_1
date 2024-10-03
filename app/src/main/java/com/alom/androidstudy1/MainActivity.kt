package com.alom.androidstudy1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alom.androidstudy1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = getSharedPreferences("alom", MODE_PRIVATE)

        // viewModel의 인자값으로 repository를 넘겨 줌
        val repository = RepositoryImpl(sharedPreference)
        val factory = ViewModelFactory(repository)

        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    mainViewModel.currentMemo.collect{ memo ->
                        binding.etMemo.setText(memo)
                        Log.d("MainActivity", "output memo: $memo")
                    }
                }
            }
        }

        binding.btnSave.setOnClickListener {
            val newMemo = binding.etMemo.text.toString().trim()
            if(newMemo.isEmpty()){
                Toast.makeText(this, "저장할 메모를 입력해 주세요", Toast.LENGTH_SHORT).show()
            }
            else {
                mainViewModel.updateValue(newMemo)
                Toast.makeText(this, "저장됨", Toast.LENGTH_SHORT).show()
            }
        }
    }
}