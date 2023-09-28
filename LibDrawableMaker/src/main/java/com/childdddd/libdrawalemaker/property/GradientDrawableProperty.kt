package com.childdddd.libdrawalemaker.property

import androidx.annotation.ColorInt

/**
 * @Author dangxiaohan
 * @Date 2023/9/27-11:37
 * @Describe: GradientDrawable属性
 */


/**
 * 圆角属性
 * @property radius     IntArray 圆角半径
 * @property solidColor Int 填充颜色
 * @constructor
 */
data class CornerProperty(var radius: IntArray, @ColorInt var solidColor: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CornerProperty

        if (!radius.contentEquals(other.radius)) return false
        if (solidColor != other.solidColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = radius.contentHashCode()
        result = 31 * result + solidColor
        return result
    }
}

/**
 * 描边属性
 * @property stokeWith  Int     描边宽度
 * @property stokeColor Int     描边颜色
 * @property dashWidth  Float   虚线宽度
 * @property dashGap    Float   虚线间隔
 * @constructor
 */
data class StokeProperty(var stokeWith: Int, @ColorInt var stokeColor: Int, var dashWidth: Float = 0F, var dashGap: Float = 0F)
