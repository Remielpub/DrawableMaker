package com.childdddd.libdrawalemaker.property

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes

/**

 * @Author Remiel
 * @Date 2023/9/27-11:40
 * @Describe
 */
/**
 *
 * @property type   Int : 状态类型
 * @property active Int : 选中状态
 * @property normal Int : 正常状态
 * @constructor
 */
data class StateProperty(val type: Int, @DrawableRes val normal: Int, @DrawableRes val active: Int)

data class StateProperty2(val type: Int, val normal: Drawable, val active: Drawable)
