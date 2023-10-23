package com.childdddd.libdrawalemaker.bindingadapter

import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.childdddd.libdrawalemaker.DrawableMaker
import com.childdddd.libdrawalemaker.property.CornerProperty
import com.childdddd.libdrawalemaker.property.GradientProperty
import com.childdddd.libdrawalemaker.property.StrokeProperty

/**
 * @Author Remiel
 * @Date 2023/9/18-14:01
 * @Describe：shape属性设置BindingAdapter
 */

@BindingAdapter(
    value =
    ["bg_drawable"], requireAll = false
)
fun View.setViewBackground(drawable: Drawable) {
    background = drawable
}

@BindingAdapter(
    value =
    ["bg_withCorners",
    "bg_withStroke",
    "bg_withGradient"], requireAll = false
)
fun View.setViewBackgroundProperty(cornerProperty: CornerProperty? = null, strokeProperty: StrokeProperty? = null,gradientProperty: GradientProperty? = null) {
    val builder = DrawableMaker.drawable()
    cornerProperty?.let {
        builder.withCorner(
            cornerProperty.radius,
            cornerProperty.solidColor,
            cornerProperty.shape,
            cornerProperty.useLevel,
            cornerProperty.level
        )
    }
    strokeProperty?.let {
        builder.withDash(
            strokeProperty.strokeWith,
            strokeProperty.strokeColor,
            strokeProperty.dashWidth,
            strokeProperty.dashGap,
            strokeProperty.shape,
            strokeProperty.useLevel,
            strokeProperty.level
        )
    }

    gradientProperty?.let {
        builder.withGradient(
            gradientProperty.colors,
            gradientProperty.orientation,
            gradientProperty.shape,
            gradientProperty.gradientType,
            gradientProperty.gradientRadius,
            gradientProperty.center,
            gradientProperty.useLevel,
            gradientProperty.level
        )
    }
    background = builder.make()
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

    background = DrawableMaker.stateDrawable().withSelected(normalDrawable, selectedDrawable).make()
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
    background = DrawableMaker.stateDrawable().withSelected(normal, selected).make()
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


