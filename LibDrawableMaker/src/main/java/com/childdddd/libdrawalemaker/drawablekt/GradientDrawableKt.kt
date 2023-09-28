package com.childdddd.libdrawalemaker.drawablekt

import android.graphics.drawable.GradientDrawable
import com.blankj.utilcode.util.SizeUtils

/**

 * @Author dangxiaohan
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
            SizeUtils.dp2px(strokeWitdh.toFloat()), stokeColor,
            SizeUtils.dp2px(dashWidth).toFloat(), SizeUtils.dp2px(dashGap).toFloat()
        )
    } else if (strokeWitdh != 0) { //设置边框描边
        setStroke(SizeUtils.dp2px(strokeWitdh.toFloat()), stokeColor)
    }
}

/**
 * 为Drawable 添加圆角
 * @param radius IntArray: 圆角大小，单位dp
 */
fun GradientDrawable.addCorners(radius: IntArray) {
    cornerRadii = floatArrayOf(
        //左上
        SizeUtils.dp2px(radius[0].toFloat()).toFloat(),
        SizeUtils.dp2px(radius[0].toFloat()).toFloat(),
        //右上
        SizeUtils.dp2px(radius[1].toFloat()).toFloat(),
        SizeUtils.dp2px(radius[1].toFloat()).toFloat(),
        //右下
        SizeUtils.dp2px(radius[2].toFloat()).toFloat(),
        SizeUtils.dp2px(radius[2].toFloat()).toFloat(),
        //左下
        SizeUtils.dp2px(radius[3].toFloat()).toFloat(),
        SizeUtils.dp2px(radius[3].toFloat()).toFloat()
    )
}
