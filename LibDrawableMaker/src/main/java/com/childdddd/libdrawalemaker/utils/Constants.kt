package com.childdddd.libdrawalemaker.utils

import android.graphics.drawable.GradientDrawable


/**
 * @Author dangxiaohan
 * @Date 2023/10/20-15:33
 * @Describe : drawable 常量属性
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

    /**
     * 渐变类型: 线性渐变
     */
    const val GRADIENT_LINEAR = GradientDrawable.LINEAR_GRADIENT

    /**
     * 渐变类型: 径向(辐射)渐变
     */
    const val GRADIENT_RADIAL = GradientDrawable.RADIAL_GRADIENT

    /**
     * 渐变类型: 扫描渐变
     */
    const val GRADIENT_SWEEP = GradientDrawable.SWEEP_GRADIENT

    /**
     * 渐变方向: 从上到下
     */
    @JvmStatic
    val ORIENTATION_TOP_BOTTOM = GradientDrawable.Orientation.TOP_BOTTOM

    /**
     * 渐变方向: 从右上到左下
     */
    @JvmStatic
    val ORIENTATION_TR_BL = GradientDrawable.Orientation.TR_BL

    /**
     * 渐变方向: 从右到左
     */
    @JvmStatic
    val ORIENTATION_RIGHT_LEFT = GradientDrawable.Orientation.RIGHT_LEFT

    /**
     * 渐变方向: 从右下到左上
     */
    @JvmStatic
    val ORIENTATION_BR_TL = GradientDrawable.Orientation.BR_TL

    /**
     * 渐变方向: 从下到上
     */
    @JvmStatic
    val ORIENTATION_BOTTOM_TOP = GradientDrawable.Orientation.BOTTOM_TOP

    /**
     * 渐变方向: 从左下到右上
     */
    @JvmStatic
    val ORIENTATION_BL_TR = GradientDrawable.Orientation.BL_TR

    /**
     * 渐变方向: 从左到右
     */
    @JvmStatic
    val ORIENTATION_LEFT_RIGHT = GradientDrawable.Orientation.LEFT_RIGHT

    /**
     * 渐变方向: 从左上到右下
     */
    @JvmStatic
    val ORIENTATION_TL_BR = GradientDrawable.Orientation.TL_BR

}
