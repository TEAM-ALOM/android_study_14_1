package com.alom.androidstudy1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alom.androidstudy1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var textViewModel: TextViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val viewModelFactory =TextViewModelFactory(TextRepository(this))
        textViewModel = ViewModelProvider(this, viewModelFactory).get(TextViewModel::class.java)
//        val sharedPreferences = getSharedPreferences("alom", MODE_PRIVATE)
//        val saveText = sharedPreferences.getString("text","")

        lifecycleScope.launch{
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){

                    textViewModel.currentValue.collect{value->
                        binding.editText.setText(value)
                    }

            }
        }

            binding.button.setOnClickListener{
                handleButtonClick()}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun handleButtonClick(){
        val userInputString = binding.editText.text.toString()
            textViewModel.updateValue(userInputString)

    }
}