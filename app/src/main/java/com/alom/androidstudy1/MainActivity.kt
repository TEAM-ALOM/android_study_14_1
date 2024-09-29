package com.alom.androidstudy1

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.alom.androidstudy1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnClickListener {
    private lateinit var memoViewModel : MemoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //뷰바인딩 적용
        val binding = ActivityMainBinding.inflate(layoutInflater)
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
    }

    override fun onClick(view: View?) {
        //SharedPreference 저장 함수 호출
    }
}