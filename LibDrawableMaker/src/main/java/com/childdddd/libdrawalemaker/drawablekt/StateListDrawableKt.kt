package com.childdddd.libdrawalemaker.drawablekt

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.util.Log


/**
 * @Author dangxiaohan
 * @Date 2023/9/26-10:58
 * @Describe
 */

fun StateListDrawable.addSelectedState(type: Int, normal: Drawable, selected: Drawable) {
    Log.d("dang", " addSelectedState type = $type")
    addState(intArrayOf(type), selected)
    addState(intArrayOf(), normal)
}


