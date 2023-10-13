package com.remiel.drawablemaker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.remiel.drawablemaker.databinding.ActivityDrawableTestBinding

/**

 * @Author dangxiaohan
 * @Date 2023/10/12-14:18
 * @Describe
 */
class DrawableTestActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDrawableTestBinding

    companion object {
        fun start(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, DrawableTestActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawableTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
