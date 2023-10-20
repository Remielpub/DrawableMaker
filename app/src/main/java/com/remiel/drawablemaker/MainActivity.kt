package com.remiel.drawablemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.remiel.drawablemaker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bt1.setOnClickListener {
            GradientDrawableActivity.start(this)
        }

        binding.bt2.setOnClickListener {
            StateListDrawableActivity.start(this)
        }
    }
}
