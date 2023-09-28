package com.childdddd.libdrawalemaker.utils

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.annotation.ColorInt

/**
 * @Author dangxiaohan
 * @Date 2023/9/28-10:56
 * @Describe
 */


fun parseColor(colorStr: String?): Int {
    if (colorStr.isNullOrEmpty()) {
        return Color.TRANSPARENT
    }
    var color = Color.TRANSPARENT

    try {
        color = Color.parseColor(colorStr)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return color
}

fun createColorList(index: Int, @ColorInt normal: Int, @ColorInt selected: Int): ColorStateList {
    val i = if (index >= 0 && index < StateListDrawableUtil.PROPERTYS.size) {
        index
    } else {
        StateListDrawableUtil.INDEX_SELECTED
    }
    val stateList = arrayOf(intArrayOf(StateListDrawableUtil.PROPERTYS[i]), intArrayOf())

    val colorList = if (normal == 0) {
        intArrayOf(selected, Color.BLACK)
    } else {
        intArrayOf(selected, normal)
    }
    return ColorStateList(stateList, colorList)
}
