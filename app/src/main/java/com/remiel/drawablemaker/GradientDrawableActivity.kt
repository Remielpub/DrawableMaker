package com.remiel.drawablemaker

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.childdddd.libdrawalemaker.utils.GradientDrawableUtil
import com.remiel.drawablemaker.databinding.ActivityGradientdrawableBinding

/**

 * @Author Remiel
 * @Date 2023/9/27-14:42
 * @Describe : GradientDrawable 用法页面
 */
class GradientDrawableActivity: AppCompatActivity() {
    private lateinit var binding: ActivityGradientdrawableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGradientdrawableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawable = GradientDrawableUtil.drawable(10, Color.RED,  5, Color.BLUE)
        binding.tv1.background = drawable
    }

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, GradientDrawableActivity::class.java))
        }
    }
}
