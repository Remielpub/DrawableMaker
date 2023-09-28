package com.childdddd.libdrawalemaker.bindingadapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.childdddd.libdrawalemaker.property.CornerProperty
import com.childdddd.libdrawalemaker.property.StateProperty
import com.childdddd.libdrawalemaker.property.StateProperty2
import com.childdddd.libdrawalemaker.property.StokeProperty
import com.childdddd.libdrawalemaker.utils.GradientDrawableUtil
import com.childdddd.libdrawalemaker.utils.StateListDrawableUtil
import com.childdddd.libdrawalemaker.utils.StateListDrawableUtil.INDEX_SELECTED

/**
 * @Author Remiel
 * @Date 2023/9/18-14:01
 * @Describe：shape属性设置BindingAdapter
 */

/**
 * 添加边框 / 虚线描边 bindingAdapter
 *
 * @receiver View
 * @param radius      IntArray?  : 圆角大小，单位dp
 * @param solidColor  Int        : 填充颜色, ColorInt
 * @param strokeWitdh Int        : 边框宽度，单位dp
 * @param stokeColor  Int        : 边框颜色, ColorInt
 * @param dashWidth   Float      : 虚线宽度，单位dp
 * @param dashGap     Float      : 虚线间隔，单位dp
 */
@BindingAdapter(
    value =
    [   "bg_corners",     //Shape 圆角
        "bg_solidColor",  //Shape solidColor
        "bg_strokeWitdh", //Shape 描边宽度
        "bg_strokeColor", //Shape 描边颜色
        "bg_dashWidth",   //Shape 虚线宽度
        "bg_dashGap"      //Shape 虚线间隔
    ], requireAll = false
)
fun View.setViewBackground(
    radius: IntArray? = null,
    @ColorInt solidColor: Int = Color.TRANSPARENT,
    strokeWitdh: Int = 0,
    @ColorInt stokeColor: Int = Color.TRANSPARENT,
    dashWidth: Float = 0f,
    dashGap: Float = 0f
) {
    background = GradientDrawableUtil.drawable(
        radius,
        solidColor,
        strokeWitdh,
        stokeColor,
        dashWidth,
        dashGap
    )
}

/**
 * 添加圆角背景
 *
 * @receiver      [View]
 * @param corner  [CornerProperty] : 圆角及背景属性值
 * @param stroke   [StokeProperty]  : 描边属性值
 */
@BindingAdapter(
    value =
    ["bg_addCorners", "bg_addStroke"], requireAll = false
)
fun View.setViewBackground(
    corner: CornerProperty? = null,
    stroke: StokeProperty? = null
) {
    background = GradientDrawableUtil.drawable(corner, stroke)
}

/**
 * 添加图片selector 选择器背景, Drawable & Mipmap
 *
 * @receiver       [View]
 * @param normal   [Int]  : 默认状态图片Id
 * @param selected [Int]  : 选中状态图片Id
 */
@BindingAdapter(
    value =
    ["bg_imageNormal", "bg_imageSelected"], requireAll = true
)
fun View.setImageBackground(@DrawableRes normal: Int, @DrawableRes selected: Int) {
    val normalDrawable = resources.getDrawable(normal)

    val selectedDrawable = resources.getDrawable(selected)

    background = StateListDrawableUtil.drawable(INDEX_SELECTED, normalDrawable, selectedDrawable)
}

/**
 * 添加图片selector 选择器背景
 *
 * @receiver       [View]
 * @param normal   [Int]  : 默认状态drawable
 * @param selected [Int]  : 选中状态drawable
 */
@BindingAdapter(
    value =
    ["bg_drawableNormal", "bg_drawableSelected"], requireAll = true
)
fun View.setImageBackground(normal: Drawable, selected: Drawable) {
    background = StateListDrawableUtil.drawable(INDEX_SELECTED, normal, selected)
}

/**
 * 添加颜色selector 选择器背景
 *
 * @receiver       [View]
 * @param normal   [Int]  : 默认状态颜色
 * @param selected [Int]  : 选中状态颜色
 */
@BindingAdapter(
    value =
    ["bg_normalColor", "bg_selectedColor"], requireAll = true
)
fun View.setColorBackground(@ColorInt normal: Int, @ColorInt selected: Int) {
    val normalDrawable = ColorDrawable(normal)

    val selectedDrawable = ColorDrawable(selected)

    background = StateListDrawableUtil.drawable(INDEX_SELECTED, normalDrawable, selectedDrawable)
}

/**
 * 添加selector 选择器背景
 *
 * @receiver        [View]
 * @param property [StateProperty] : 状态属性值
 */
@BindingAdapter(
    value =
    ["bg_state"], requireAll = false
)
fun View.setSelectorBackground(property: StateProperty) {
    val normalDrawable = resources.getDrawable(property.normal)

    val selectedDrawable = resources.getDrawable(property.active)

    background = StateListDrawableUtil.drawable(property.type, normalDrawable, selectedDrawable)
}

/**
 * 添加selector 选择器背景
 *
 * @receiver        [View]
 * @param property [StateProperty2] : 状态属性值
 *
 */
@BindingAdapter(
    value =
    ["bg_state2"], requireAll = false
)
fun View.setSelectorBackground(property: StateProperty2) {
    background = StateListDrawableUtil.drawable(property.type, property.normal, property.active)
}



@BindingAdapter(value = ["bindSelected"])
fun View.bindSelected(isSelected: MutableLiveData<Boolean>) {

    isSelected.observe(context as AppCompatActivity) {

        setSelected(it)
    }
    setSelected(isSelected.value!!)
}

@BindingAdapter(value = ["bindEnabled"])
fun View.bindEnabled(enable: MutableLiveData<Boolean>) {
    enable.observe(context as AppCompatActivity) {
        isEnabled = it
    }
    isEnabled = enable.value!!

}


