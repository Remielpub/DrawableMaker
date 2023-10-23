package com.childdddd.libdrawalemaker.factory

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import com.childdddd.libdrawalemaker.property.CornerProperty
import com.childdddd.libdrawalemaker.property.GradientProperty
import com.childdddd.libdrawalemaker.property.GradientType
import com.childdddd.libdrawalemaker.property.Shape
import com.childdddd.libdrawalemaker.property.StateProperty2
import com.childdddd.libdrawalemaker.property.StrokeProperty
import com.childdddd.libdrawalemaker.utils.Constants
import com.childdddd.libdrawalemaker.utils.Constants.NONE
import com.childdddd.libdrawalemaker.utils.DrawableUtil.cornerRadius
import com.childdddd.libdrawalemaker.utils.parseColor

/**
 * @Author dangxiaohan
 * @Date 2023/10/13-11:42
 * @Describe
 */
object PropertyFactory {
    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param solidColor String: 填充颜色, 颜色值，如 #000000
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(solidColor: String): CornerProperty {
        return cornerProperty(0, solidColor)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param solidColor Int : 填充颜色, ColorInt
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(@ColorInt solidColor: Int): CornerProperty {
        return cornerProperty(0, solidColor)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius     Int      : 圆角数值，单位dp
     * @param solidColor Int      : 填充颜色, ColorInt
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(radius: Int, solidColor: String): CornerProperty {
        return CornerProperty(cornerRadius(radius), parseColor(solidColor))
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius Int        : 圆角数值，单位dp
     * @param solidColor Int    : 填充颜色, ColorInt
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(radius: Int, @ColorInt solidColor: Int): CornerProperty {
        return CornerProperty(cornerRadius(radius), solidColor)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius IntArray   : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor String : 填充颜色, 颜色值，如 #000000
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(radius: IntArray, solidColor: String): CornerProperty {
        return CornerProperty(radius, parseColor(solidColor))
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius IntArray   : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor Int    : 填充颜色, ColorInt
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(radius: IntArray, @ColorInt solidColor: Int): CornerProperty {
        return CornerProperty(radius, solidColor)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius Int        : 圆角数值，单位dp
     * @param solidColor String : 填充颜色, 颜色值，如 #000000
     * @param shape Int         : 形状
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(radius: Int, solidColor: String, @Shape shape: Int): CornerProperty {
        return CornerProperty(cornerRadius(radius), parseColor(solidColor), shape)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius Int        : 圆角数值，单位dp
     * @param solidColor Int    : 填充颜色, ColorInt
     * @param shape Int         : 形状
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(radius: Int, @ColorInt solidColor: Int, @Shape shape: Int): CornerProperty {
        return CornerProperty(cornerRadius(radius), solidColor, shape)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius IntArray       : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor String     : 填充颜色, 颜色值，如 #000000
     * @param shape Int             : 形状
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(radius: IntArray, solidColor: String, @Shape shape: Int): CornerProperty {
        return CornerProperty(radius, parseColor(solidColor), shape)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius IntArray    : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor Int     : 填充颜色, ColorInt
     * @param shape Int          : 形状
     * @return CornerProperty
     */
    @JvmStatic
    fun cornerProperty(radius: IntArray, @ColorInt solidColor: Int, @Shape shape: Int): CornerProperty {
        return CornerProperty(radius, solidColor, shape)
    }

    /**
     * 圆角 & 背景颜色 Drawable 生成属性
     *
     * @param radius IntArray    : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor Int     : 填充颜色, ColorInt
     * @param shape Int          : 形状
     * @param useLevel Boolean   : 是否使用level
     * @param level Int          : level值
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
        return CornerProperty(radius, solidColor, shape, useLevel, level)
    }

    /**
     * 四个角 圆角角度 不同 & 背景颜色 Drawable 生成属性
     *
     * @param radius IntArray   : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor String : 填充颜色, 颜色值，如 #000000
     * @param shape Int         : 形状
     * @param useLevel Boolean  : 是否使用level
     * @param level Int         : level值
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
        return CornerProperty(radius, parseColor(solidColor), shape, useLevel, level)
    }

    /**
     *
     * 实线边框 Drawable 生成属性
     *
     * @param strokeWidth Int       : 边框宽度，单位dp
     * @param strokeColor String    : 边框颜色，颜色值，如 #000000
     * @return StrokeProperty
     */
    @JvmStatic
    fun strokeProperty(
        strokeWidth: Int,
        strokeColor: String
    ): StrokeProperty {
        return strokeProperty(strokeWidth, parseColor(strokeColor))
    }

    /**
     * 实线边框 Drawable 生成属性
     *
     * @param strokeWidth Int   : 边框宽度，单位dp
     * @param strokeColor Int   : 边框颜色，ColorInt
     * @return StrokeProperty
     */
    @JvmStatic
    fun strokeProperty(
        strokeWidth: Int,
        @ColorInt strokeColor: Int
    ): StrokeProperty {
        return StrokeProperty(strokeWidth, strokeColor, 0F, 0F, NONE, false, 10000)
    }

    /**
     * 实线边框 Drawable 生成属性
     *
     * @param strokeWidth Int       : 边框宽度，单位dp
     * @param strokeColor String    : 边框颜色，颜色值，如 #000000
     * @param shape Int             : 形状
     * @return StrokeProperty
     */
    @JvmStatic
    fun strokeProperty(
        strokeWidth: Int,
        strokeColor: String,
        @Shape shape: Int = NONE,
    ): StrokeProperty {
        return strokeProperty(strokeWidth, parseColor(strokeColor), shape, false, 10000)
    }

    /**
     * 实线边框 Drawable 生成属性
     *
     * @param strokeWidth Int   : 边框宽度，单位dp
     * @param strokeColor Int   : 边框颜色，ColorInt
     * @param shape Int         : 形状
     * @return StrokeProperty
     */
    @JvmStatic
    fun strokeProperty(
        strokeWidth: Int,
        @ColorInt strokeColor: Int,
        @Shape shape: Int
    ): StrokeProperty {
        return strokeProperty(strokeWidth, strokeColor, shape, false, 10000)
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
        @Shape shape: Int = NONE,
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
        @Shape shape: Int = NONE,
        useLevel: Boolean = false,
        @IntRange(from = 0, to = 10000) level: Int
    ): StrokeProperty {
        return strokeProperty(strokeWidth, parseColor(strokeColor), shape, useLevel, level)
    }

    @JvmStatic
    fun dashProperty(
        strokeWidth: Int, strokeColor: String, dashWidth: Float, dashGap: Float
    ): StrokeProperty {
        return StrokeProperty(strokeWidth, parseColor(strokeColor), dashWidth, dashGap, NONE, false, 10000)
    }

    @JvmStatic
    fun dashProperty(
        strokeWidth: Int, @ColorInt strokeColor: Int, dashWidth: Float, dashGap: Float
    ): StrokeProperty {
        return StrokeProperty(strokeWidth, strokeColor, dashWidth, dashGap, NONE, false, 10000)
    }

    @JvmStatic
    fun dashProperty(
        strokeWidth: Int, strokeColor: String, dashWidth: Float, dashGap: Float, @Shape shape: Int
    ): StrokeProperty {
        return StrokeProperty(strokeWidth, parseColor(strokeColor), dashWidth, dashGap, shape, false, 10000)
    }

    @JvmStatic
    fun dashProperty(
        strokeWidth: Int, @ColorInt strokeColor: Int, dashWidth: Float, dashGap: Float, @Shape shape: Int
    ): StrokeProperty {
        return StrokeProperty(strokeWidth, strokeColor, dashWidth, dashGap, shape, false, 10000)
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
        @Shape shape: Int = NONE,
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
        @Shape shape: Int = NONE,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): StrokeProperty {
        return dashProperty(strokeWidth, parseColor(strokeColor), dashWidth, dashGap, shape, useLevel, level)
    }

    /**
     * 渐变 Drawable 生成属性
     *
     * @param colors IntArray           :  渐变颜色数组
     * @param orientation Orientation   :  渐变方向
     * @return GradientProperty
     */
    @JvmStatic
    fun gradientProperty(colors: IntArray,
                         orientation: GradientDrawable.Orientation): GradientProperty {
        return GradientProperty(colors, orientation, GradientDrawable.LINEAR_GRADIENT, 0F, Pair(0.5F, 0.5F), NONE, false, 10000)
    }

    /**
     * 渐变 Drawable 生成属性
     *
     * @param colors IntArray           :  渐变颜色数组
     * @param orientation Orientation   :  渐变方向
     * @param shape Int                 :  渐变形状，支持矩形、椭圆
     * @return GradientProperty
     */
    @JvmStatic
    fun gradientProperty(colors: IntArray,
                         orientation: GradientDrawable.Orientation, @Shape shape: Int): GradientProperty {
        return GradientProperty(colors, orientation, GradientDrawable.LINEAR_GRADIENT, 0F, Pair(0.5F, 0.5F), shape, false, 10000)
    }

    /**
     * 渐变 Drawable 生成属性
     *
     * @param colors IntArray           :  渐变颜色数组
     * @param orientation Orientation   :  渐变方向
     * @param gradientType Int          :  渐变类型，支持线性渐变、径向(雷达)渐变、扫描渐变
     * @param shape Int                 :  渐变形状，支持矩形、椭圆
     * @param useLevel Boolean          :  是否使用level
     * @param level Int                 :  level值
     * @return GradientProperty
     */
    @JvmStatic
    fun gradientProperty(colors: IntArray,
                         orientation: GradientDrawable.Orientation,
                         @GradientType gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
                         @Shape shape: Int = NONE,
                         useLevel: Boolean = false,
                         level: Int = 10000): GradientProperty {
        return GradientProperty(colors, orientation, gradientType, 0F, Pair(0.5F, 0.5F), shape, useLevel, level)
    }

    /**
     * 渐变 Drawable 生成属性
     *
     * @param colors IntArray           :  渐变颜色数组
     * @param orientation Orientation   :  渐变方向
     * @param gradientType Int          :  渐变类型，支持线性渐变、径向(雷达)渐变、扫描渐变
     * @param gradientRadius Float      :  渐变半径，仅在渐变类型为径向渐变时有效
     * @param center Pair<Float, Float> :  渐变中心点，仅在渐变类型为径向渐变时有效
     * @param shape Int                 :  渐变形状，支持矩形、椭圆
     * @param useLevel Boolean          :  是否使用level
     * @param level Int                 :  level值
     * @return GradientProperty
     */
    @JvmStatic
    fun gradientProperty(colors: IntArray,
                         orientation: GradientDrawable.Orientation,
                         @GradientType gradientType: Int = Constants.GRADIENT_LINEAR,
                         gradientRadius: Float,
                         center: Pair<Float, Float>,
                         @Shape shape: Int,
                         useLevel: Boolean,
                         level: Int): GradientProperty {
        return GradientProperty(colors, orientation, gradientType, gradientRadius, center, shape, useLevel, level)
    }

    /**
     * selector Drawable 生成属性
     *
     * @param type Int          :  选择器类型
     * [com.childdddd.libdrawalemaker.utils.Constants.INDEX_SELECTED] : 选中状态, 0
     * [com.childdddd.libdrawalemaker.utils.Constants.INDEX_ENABLED]  : 使能状态, 1
     * [com.childdddd.libdrawalemaker.utils.Constants.INDEX_PRESSED]  : 按下状态, 2
     * [com.childdddd.libdrawalemaker.utils.Constants.INDEX_CHECKED]  : 勾选状态, 3
     * [com.childdddd.libdrawalemaker.utils.Constants.INDEX_FOCUSED]  : 聚焦状态, 4
     * 这里将以上常用的状态类型封装成了常量，也可以直接使用[android.R.attr.DrawableStates]中的其他属性
     *
     * @param normal Drawable
     * @param active Drawable
     * @return StateProperty2
     */
    @JvmStatic
    fun stateProperty(type: Int, normal: Drawable, active: Drawable): StateProperty2 {
        return StateProperty2(type, normal, active)
    }
}
