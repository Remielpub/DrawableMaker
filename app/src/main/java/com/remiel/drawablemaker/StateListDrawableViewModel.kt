package com.remiel.drawablemaker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**

 * @Author dangxiaohan
 * @Date 2023/9/27-18:16
 * @Describe
 */
class StateListDrawableViewModel: ViewModel() {
    var selected = MutableLiveData(false)
}
