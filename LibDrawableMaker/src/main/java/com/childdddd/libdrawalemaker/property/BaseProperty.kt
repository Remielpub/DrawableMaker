package com.childdddd.libdrawalemaker.property

import android.graphics.drawable.Drawable
import androidx.annotation.IntRange
import com.childdddd.libdrawalemaker.drawablekt.commonProperty

/**
 * @Author dangxiaohan
 * @Date 2023/10/12-15:12
 * @Describe
 */
open class BaseProperty(
    @IntRange(from = 0, to= 10000) open var level: Int = 10000,
    var stateSet: IntArray = intArrayOf()
) {
    open fun draw(drawable: Drawable) {
        drawable.commonProperty(level)
    }
}
