package com.childdddd.libdrawalemaker.utils

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.util.Log
import androidx.annotation.DrawableRes
import com.childdddd.libdrawalemaker.drawablekt.addSelectedState
import com.childdddd.libdrawalemaker.property.StateProperty
import com.childdddd.libdrawalemaker.property.StateProperty2

/**

 * @Author dangxiaohan
 * @Date 2023/9/26-15:53
 * @Describe
 */
object StateListDrawableUtil {
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

        internal val PROPERTYS = arrayOf(
            PROPERTY_SELECTED,
            PROPERTY_ENABLED,
            PROPERTY_PRESSED,
            PROPERTY_CHECKED,
            PROPERTY_FOCUSED
        )

        /**
         * 生成 StateProperty2 属性对象
         * @param index Int
         * @param normal Int
         * @param active Int
         * @return StateProperty
         */
        @JvmStatic
        fun setState(index: Int, @DrawableRes normal: Int, @DrawableRes active: Int): StateProperty {
            val i = if (index >=0 && index < PROPERTYS.size) index else 0
            return StateProperty(i, normal, active)
        }

        /**
         * 生成 StateProperty2 属性对象
         *
         * @param index Int
         * @param normal Drawable
         * @param active Drawable
         * @return StateProperty2
         */
        @JvmStatic
        fun setState2(index: Int, normal: Drawable, active: Drawable): StateProperty2 {
            val i = if (index >= 0 && index < PROPERTYS.size) index else 0
            return StateProperty2(i, normal, active)
        }

        /**
         * 生成 StateListDrawable 对象
         *
         * @param index Int         : 状态类型，如下
         * [INDEX_SELECTED]         : 0
         * [INDEX_ENABLED]          : 1
         * [INDEX_PRESSED]          : 2
         * [INDEX_CHECKED]          : 3
         * [INDEX_FOCUSED]          : 4
         *
         * @param normal Drawable   : 正常状态
         * @param active Drawable   : 选中状态
         * @return Drawable
         */
        @JvmStatic
        fun drawable(index: Int, normal: Drawable, active: Drawable): Drawable {
            Log.d("dang", " drawable index = $index")
            val i = if (index >= 0 && index < PROPERTYS.size) index else 0
            return StateListDrawable().apply {
                addSelectedState(PROPERTYS[i], normal, active)
            }
        }
    }
