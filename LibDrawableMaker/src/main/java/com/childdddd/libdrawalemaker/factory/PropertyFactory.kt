package com.childdddd.libdrawalemaker.factory

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import com.childdddd.libdrawalemaker.property.CornerProperty
import com.childdddd.libdrawalemaker.property.GradientProperty
import com.childdddd.libdrawalemaker.property.GradientType
import com.childdddd.libdrawalemaker.property.Shape
import com.childdddd.libdrawalemaker.property.StrokeProperty
import com.childdddd.libdrawalemaker.utils.GradientDrawableUtil.cornerRadius
import com.childdddd.libdrawalemaker.utils.parseColor

/**
 * @Author dangxiaohan
 * @Date 2023/10/13-11:42
 * @Describe
 */
object PropertyFactory {

    /**
     * 圆角Drawable 生成属性，
     *
     * @param radius Int : 圆角大小，单位dp,
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(vararg radius: Int): CornerProperty {
        return CornerProperty(cornerRadius(radius), Color.TRANSPARENT)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius     IntArray : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor Int      : 填充颜色, ColorInt
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(vararg radius: Int, @ColorInt solidColor: Int): CornerProperty {
        return CornerProperty(cornerRadius(radius), solidColor)
    }

    @JvmStatic
    fun cornerProperty(radius: Int, solidColor: String): CornerProperty {
        return CornerProperty(cornerRadius(intArrayOf(radius)), parseColor(solidColor))
    }
    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius     IntArray : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor Int      : 填充颜色, ColorInt
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(
        radius: IntArray,
        @ColorInt solidColor: Int,
        @Shape shape: Int ,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): CornerProperty {
        return CornerProperty(cornerRadius(radius), solidColor, shape, useLevel, level)
    }
    /**
     * 四个角 圆角角度 不同 & 背景颜色 Drawable 生成属性
     *
     * @param radius     IntArray : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor String   : 填充颜色, 颜色值，如 #000000
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(
        radius: IntArray,
        solidColor: String,
        @Shape shape: Int,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): CornerProperty {
        return CornerProperty(cornerRadius(radius), parseColor(solidColor), shape, useLevel, level)
    }

    /**
     * 实线边框 Drawable 生成属性
     *
     * @param strokeWidth Int     : 边框宽度，单位dp
     * @param strokeColor Int    : 边框颜色，ColorInt
     * @return StrokeProperty
     */
    @JvmStatic
    fun strokeProperty(
        strokeWidth: Int,
        @ColorInt strokeColor: Int,
        @Shape shape: Int = GradientDrawable.RECTANGLE,
        useLevel: Boolean ,
        @IntRange(from = 0, to = 10000) level: Int
    ): StrokeProperty {
        return StrokeProperty(strokeWidth, strokeColor, 0F, 0F, shape, useLevel, level)
    }

    /**
     * 实线边框 Drawable 生成属性
     *
     * @param strokeWidth Int     : 边框宽度，单位dp
     * @param strokeColor String : 边框颜色，颜色值，如 #000000
     * @return StrokeProperty
     */
    @JvmStatic
    fun strokeProperty(
        strokeWidth: Int,
        strokeColor: String,
        @Shape shape: Int = GradientDrawable.RECTANGLE,
        useLevel: Boolean = false,
        @IntRange(from = 0, to = 10000) level: Int
    ): StrokeProperty {
        return strokeProperty(strokeWidth, parseColor(strokeColor), shape, useLevel, level)
    }

    /**
     * 虚线边框 Drawable 生成属性
     *
     * @param strokeWidth Int      : 虚线宽度，单位dp
     * @param strokeColor Int     : 虚线颜色，ColorInt
     * @param dashWidth Float    : 单条虚线长度，单位dp
     * @param dashGap Float      : 虚线间隔，单位dp
     * @return StrokeProperty
     */
    @JvmStatic
    fun dashProperty(
        strokeWidth: Int, @ColorInt strokeColor: Int, dashWidth: Float, dashGap: Float,
        @Shape shape: Int = GradientDrawable.RECTANGLE,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): StrokeProperty {
        return StrokeProperty(strokeWidth, strokeColor, dashWidth, dashGap, shape, useLevel, level)
    }

    /**
     * 虚线边框 Drawable 生成属性
     *
     * @param strokeWidth Int     : 虚线宽度，单位dp
     * @param strokeColor String : 虚线颜色，颜色值，如 #000000
     * @param dashWidth Float   : 单条虚线长度，单位dp
     * @param dashGap Float     : 虚线间隔，单位dp
     * @return StrokeProperty
     */
    @JvmStatic
    fun dashProperty(
        strokeWidth: Int,
        strokeColor: String,
        dashWidth: Float,
        dashGap: Float,
        @Shape shape: Int = GradientDrawable.RECTANGLE,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): StrokeProperty {
        return dashProperty(strokeWidth, parseColor(strokeColor), dashWidth, dashGap, shape, useLevel, level)
    }

    @JvmStatic
    fun gradientProperty(colors: IntArray,
                         orientation: GradientDrawable.Orientation,
                         @GradientType gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
                         @Shape shape: Int = GradientDrawable.RECTANGLE,
                         useLevel: Boolean = false,
                         level: Int = 10000): GradientProperty {
        return GradientProperty(colors, orientation, gradientType, 0F, Pair(0.5F, 0.5F), shape, useLevel, level)
    }

    @JvmStatic
    fun gradientProperty(colors: IntArray,
                         orientation: GradientDrawable.Orientation,
                         @GradientType gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
                         gradientRadius: Float,
                         center: Pair<Float, Float>,
                         @Shape shape: Int,
                         useLevel: Boolean,
                         level: Int): GradientProperty {
        return GradientProperty(colors, orientation, gradientType, gradientRadius, center, shape, useLevel, level)
    }
}
