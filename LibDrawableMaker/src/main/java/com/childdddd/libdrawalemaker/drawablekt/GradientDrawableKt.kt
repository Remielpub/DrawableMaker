package com.childdddd.libdrawalemaker.drawablekt

import android.graphics.drawable.GradientDrawable
import com.childdddd.libdrawalemaker.utils.dp

/**

 * @Author Remiel
 * @Date 2023/9/26-10:52
 * @Describe
 */

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
