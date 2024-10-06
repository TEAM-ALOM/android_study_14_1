package com.alom.androidstudy1

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alom.androidstudy1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),OnClickListener {
    private lateinit var memoViewModel : MemoViewModel
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //뷰바인딩 적용
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //ViewModel
        memoViewModel = ViewModelProvider(this).get(MemoViewModel::class.java)

        //버튼 리스너 설정
        binding.button.setOnClickListener(this)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    memoViewModel.currentText.collect{
                        //EditText Text를 SharedPreferences에서 불러온 글자로 변경
                        binding.editTextTextMultiLine.setText(it)
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        memoViewModel.returnMemo(applicationContext)
    }

    override fun onClick(view: View?) {
        //SharedPreference 저장 함수 호출
        memoViewModel.saveMemo(binding.editTextTextMultiLine.text.toString(),applicationContext)
    }
}