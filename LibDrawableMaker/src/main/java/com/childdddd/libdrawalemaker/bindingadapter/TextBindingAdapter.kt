package com.childdddd.libdrawalemaker.bindingadapter

import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import com.childdddd.libdrawalemaker.property.ColorStateListProperty
import com.childdddd.libdrawalemaker.property.ColorStateListProperty2
import com.childdddd.libdrawalemaker.utils.Constants.INDEX_SELECTED
import com.childdddd.libdrawalemaker.utils.createColorList
import com.childdddd.libdrawalemaker.utils.parseColor

/**

 * @Author Remiel
 * @Date 2023/9/28-18:01
 * @Describe
 */

/**
 * 设置TextView 字体根据状态更换颜色
 *
 * @receiver       [TextView]
 * @param normal   [Int] : 正常状态颜色
 * @param selected [Int] : 选中状态颜色
 */
@BindingAdapter(
    value =
    ["text_normalColor", "text_selectedColor"], requireAll = true
)
fun TextView.setTextColor(@ColorInt normal: Int, @ColorInt selected: Int) {
    setTextColor(createColorList(INDEX_SELECTED, normal, selected))
}

/**
 * 设置TextView 字体根据状态更换颜色
 *
 * @receiver TextView
 * @param property [ColorStateListProperty]   : 状态属性值
 */
@BindingAdapter(
    value =
    ["text_state"], requireAll = true
)
fun TextView.setTextColor(property: ColorStateListProperty) {
    setTextColor(createColorList(property.type, property.normal, property.active))
}

/**
 * 设置TextView 字体根据状态更换颜色
 *
 * @receiver TextView
 * @param property [ColorStateListProperty2]   : 状态属性值
 */
@BindingAdapter(
    value =
    ["text_state2"], requireAll = true
)
fun TextView.setTextColor(property: ColorStateListProperty2) {
    val normal = parseColor(property.normal)
    val active = parseColor(property.active)

    setTextColor(createColorList(property.type, normal, active))
}
