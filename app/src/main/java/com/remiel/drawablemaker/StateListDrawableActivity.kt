package com.remiel.drawablemaker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.remiel.drawablemaker.databinding.ActivityStatelistdrawableBinding

/**
 * @Author Remiel
 * @Date 2023/9/27-14:42
 * @Describe
 */
class StateListDrawableActivity: AppCompatActivity() {
    private lateinit var binding: ActivityStatelistdrawableBinding

    private lateinit var vm: StateListDrawableViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[StateListDrawableViewModel::class.java]
        binding = ActivityStatelistdrawableBinding.inflate(layoutInflater)
        binding.vm = vm

        setContentView(binding.root)

        val listener = View.OnClickListener {
            val selected = vm.selected.value
            vm.selected.postValue(selected!!.not())
        }

        binding.tv1.setOnClickListener(listener)
        binding.tv2.setOnClickListener(listener)
        binding.tv3.setOnClickListener(listener)
        binding.tv4.setOnClickListener(listener)
        binding.tv5.setOnClickListener(listener)

    }

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, StateListDrawableActivity::class.java))
        }
    }
}
