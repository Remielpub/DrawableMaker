package com.childdddd.libdrawalemaker.provider

import android.app.Application
import androidx.core.content.FileProvider
import com.childdddd.libdrawalemaker.utils.Utils

/**

 * @Author dangxiaohan
 * @Date 2023/10/18-14:04
 * @Describe
 */
class UtilsFileProvider: FileProvider() {
    override fun onCreate(): Boolean {
        Utils.init(this.context?.applicationContext as Application)
        return super.onCreate()
    }
}
