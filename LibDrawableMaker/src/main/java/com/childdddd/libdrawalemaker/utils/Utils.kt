package com.childdddd.libdrawalemaker.utils

import android.app.Application

/**
 * @Author dangxiaohan
 * @Date 2023/10/18-14:08
 * @Describe
 */
object Utils {

    private lateinit var app: Application
    @JvmStatic
    fun init(app: Application) {
        this.app = app
    }

    fun getApp(): Application {
        return app
    }
}
