package com.childdddd.libdrawalemaker.property

import androidx.annotation.ColorInt
/**

 * @Author Remiel
 * @Date 2023/9/28-17:25
 * @Describe
 */

/**
 *
 *
 * @property type       Int    : 状态类型
 * [INDEX_SELECTED] : 选中状态
 * [INDEX_ENABLED]  : 使能状态
 * [INDEX_PRESSED]  : 按下状态
 * [INDEX_CHECKED]  : 勾选状态
 * [INDEX_FOCUSED]  : 聚焦状态
 *
 * @property normal     Int     : 正常状态
 * @property active     Int     : 选中状态
 * @constructor
 */
data class ColorStateListProperty(val type: Int, @ColorInt val normal: Int, val active: Int)

data class ColorStateListProperty2(val type: Int, val normal: String, val active: String)
