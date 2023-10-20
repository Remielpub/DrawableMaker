package com.childdddd.libdrawalemaker.utils

import android.graphics.drawable.GradientDrawable

/**

 * @Author dangxiaohan
 * @Date 2023/10/20-15:33
 * @Describe
 */
object Constants {

    const val NONE = -1

    /**
     * 矩形
     */
    const val RECTANGLE = GradientDrawable.RECTANGLE

    /**
     * 圆形 / 椭圆形
     */
    const val OVAL = GradientDrawable.OVAL

//    const val LINE = GradientDrawable.LINE
//
//    const val RING = GradientDrawable.RING

    /**
     * index : 0
     * 选中状态
     */
    internal const val PROPERTY_SELECTED = android.R.attr.state_selected
    /**
     * index : 1
     * 使能状态
     */
    internal const val PROPERTY_ENABLED = android.R.attr.state_enabled

    /**
     * index : 2
     * 按下状态
     */
    internal const val PROPERTY_PRESSED = android.R.attr.state_pressed

    /**
     * index : 3
     * 勾选状态
     */
    internal const val PROPERTY_CHECKED = android.R.attr.state_checked

    /**
     * index : 4
     * 聚焦状态
     */
    internal const val PROPERTY_FOCUSED = android.R.attr.state_focused

    /**
     * 选中状态索引
     */
    const val INDEX_SELECTED = 0

    /**
     * 使能状态索引
     */
    const val INDEX_ENABLED  = 1

    /**
     * 按下状态索引
     */
    const val INDEX_PRESSED  = 2

    /**
     * 勾选状态索引
     */
    const val INDEX_CHECKED  = 3

    /**
     * 聚焦状态索引
     */
    const val INDEX_FOCUSED  = 4
}
