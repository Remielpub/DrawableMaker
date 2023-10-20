package com.childdddd.libdrawalemaker

import com.childdddd.libdrawalemaker.builder.GradientDrawableBuilder
import com.childdddd.libdrawalemaker.builder.StateListDrawableBuilder

/**
 * @Author dangxiaohan
 * @Date 2023/10/12-11:26
 * @Describe
 */
object DrawableMaker {
    const val TAG = "DrawableMaker"

    /**
     * 创建一个GradientDrawableBuilder，创建对应属性Drawable
     * 支持Drawable属性：
     * 纯色背景
     * 圆角
     * 圆形
     * 实线边框
     * 虚线边框
     * 渐变色
     * @return GradientDrawableBuilder
     */
    @JvmStatic
    fun drawable(): GradientDrawableBuilder {
        return GradientDrawableBuilder()
    }

    /**
     * StateListDrawableBuilder，创建对应State状态的Drawable
     *
     * @return StateListDrawableBuilder
     */
    @JvmStatic
    fun stateDrawable(): StateListDrawableBuilder {
        return StateListDrawableBuilder()
    }
}

