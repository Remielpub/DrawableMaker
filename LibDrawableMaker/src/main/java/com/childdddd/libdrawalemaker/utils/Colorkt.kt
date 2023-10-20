package com.childdddd.libdrawalemaker.utils

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import androidx.annotation.ColorInt
import com.childdddd.libdrawalemaker.DrawableMaker.TAG
import com.childdddd.libdrawalemaker.property.StateProperty2.Companion.PROPERTYS
import com.childdddd.libdrawalemaker.utils.Constants.INDEX_SELECTED

/**
 * @Author Remiel
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
        Log.d(TAG, "color parse error: $colorStr")
    }
    return color
}

fun createColorList(index: Int, @ColorInt normal: Int, @ColorInt selected: Int): ColorStateList {
    val i = if (index >= 0 && index < PROPERTYS.size) {
        index
    } else {
        INDEX_SELECTED
    }
    val stateList = arrayOf(intArrayOf(PROPERTYS[i]), intArrayOf())

    val colorList = if (normal == 0) {
        intArrayOf(selected, Color.BLACK)
    } else {
        intArrayOf(selected, normal)
    }
    return ColorStateList(stateList, colorList)
}
