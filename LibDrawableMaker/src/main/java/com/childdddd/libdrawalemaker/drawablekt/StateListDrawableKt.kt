package com.childdddd.libdrawalemaker.drawablekt

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable


/**
 * @Author Remiel
 * @Date 2023/9/26-10:58
 * @Describe
 */

fun StateListDrawable.addSelectedState(type: Int, normal: Drawable, selected: Drawable) {
    addState(intArrayOf(type), selected)
    addState(intArrayOf(), normal)
}


