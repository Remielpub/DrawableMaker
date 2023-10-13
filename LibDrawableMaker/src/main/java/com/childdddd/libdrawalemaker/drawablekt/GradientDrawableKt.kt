package com.childdddd.libdrawalemaker.drawablekt

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import com.childdddd.libdrawalemaker.property.CornerProperty
import com.childdddd.libdrawalemaker.property.GradientProperty
import com.childdddd.libdrawalemaker.property.StrokeProperty
import com.childdddd.libdrawalemaker.utils.dp

/**

 * @Author Remiel
 * @Date 2023/9/26-10:52
 * @Describe
 */

fun  GradientDrawable.addStroke(strokeProperty: StrokeProperty) {
    this.shape = strokeProperty.shape
    this.addStroke(
        strokeProperty.strokeWith,
        strokeProperty.strokeColor,
        strokeProperty.dashWidth,
        strokeProperty.dashGap
    )
    this.useLevel = strokeProperty.useLevel
}

/**
 * 添加边框 / 虚线描边
 * @param drawable GradientDrawable
 * @param strokeWitdh Int   ：边框宽度，单位dp
 * @param stokeColor  Int   ：边框颜色
 * @param dashWidth   Float ：虚线宽度，单位dp
 * @param dashGap     Float ：虚线间隔，单位dp
 */
fun GradientDrawable.addStroke(
    strokeWitdh: Int,
    stokeColor: Int,
    dashWidth: Float,
    dashGap: Float
) {
    if (strokeWitdh != 0 && dashWidth != 0f && dashGap != 0f) { //设置边框描边 + 虚线
        setStroke(
            strokeWitdh.dp.toInt(), stokeColor,
            dashWidth.dp, dashGap.dp
        )
    } else if (strokeWitdh != 0) { //设置边框描边
        setStroke(strokeWitdh.dp.toInt(), stokeColor)
    }
}

fun GradientDrawable.addCorner(cornerProperty: CornerProperty) {
    this.shape = cornerProperty.shape
    this.addCorners(cornerProperty.radius)
    this.setColor(cornerProperty.solidColor)
    this.useLevel = cornerProperty.useLevel
}

/**
 * 为Drawable 添加圆角
 * @param radius IntArray: 圆角大小，单位dp
 */
fun GradientDrawable.addCorners(radius: IntArray) {
    cornerRadii = floatArrayOf(
        //左上
        radius[0].dp,
        radius[0].dp,
        //右上
        radius[1].dp,
        radius[1].dp,
        //右下
        radius[2].dp,
        radius[2].dp,
        //左下
        radius[3].dp,
        radius[3].dp,
    )
}

fun GradientDrawable.addGradient(gradientProperty: GradientProperty) {
    shape = gradientProperty.shape

    when (gradientProperty.gradientType) {
        GradientDrawable.LINEAR_GRADIENT -> {
            gradientType = GradientDrawable.LINEAR_GRADIENT
            orientation = gradientProperty.orientation
        }
        GradientDrawable.RADIAL_GRADIENT -> {
            gradientType = GradientDrawable.RADIAL_GRADIENT
            gradientRadius = gradientProperty.gradientRadius.dp
            gradientProperty.center.let {
                setGradientCenter(it.first, it.second)
            }
        }
        GradientDrawable.SWEEP_GRADIENT -> {
            gradientType = GradientDrawable.SWEEP_GRADIENT
        }
    }
    colors = gradientProperty.colors

    if (gradientProperty.useLevel) {
        useLevel = true
        level = gradientProperty.level
    }
}

fun GradientDrawable.addGradient(
    colors: IntArray,
    orientation: GradientDrawable.Orientation,
    gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
    gradientRadius: Float = 0f,
    center: Pair<Float, Float> = Pair(0.5f, 0.5f),
    useLevel: Boolean = false,
    level: Int = 10000
) {
    this.colors = colors
    this.orientation = orientation
    this.gradientType = gradientType
    if (useLevel) {
        this.useLevel = useLevel
        this.level = level
    }

    if (gradientType == GradientDrawable.RADIAL_GRADIENT) {
        this.gradientRadius = gradientRadius
        setGradientCenter(center.first, center.second)
    }
}

fun Drawable.commonProperty(level: Int) {
    this.level = level
}
