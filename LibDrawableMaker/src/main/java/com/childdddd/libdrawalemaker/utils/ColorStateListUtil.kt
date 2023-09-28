package com.childdddd.libdrawalemaker.utils

import androidx.annotation.ColorInt
import com.childdddd.libdrawalemaker.property.ColorStateListProperty
import com.childdddd.libdrawalemaker.property.ColorStateListProperty2


/**

 * @Author dangxiaohan
 * @Date 2023/9/28-17:37
 * @Describe
 */
object ColorStateListUtil {
    @JvmStatic
    fun textStateColor(type: Int, @ColorInt normal: Int, active: Int): ColorStateListProperty {
        return ColorStateListProperty(type, normal, active)
    }

    @JvmStatic
    fun textStateColor2(type: Int, normal: String, active: String): ColorStateListProperty2 {
        return ColorStateListProperty2(type, normal, active)
    }
}
