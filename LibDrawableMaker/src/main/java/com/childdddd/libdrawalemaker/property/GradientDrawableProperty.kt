package com.childdddd.libdrawalemaker.property

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.IntDef
import com.childdddd.libdrawalemaker.drawablekt.addCorner
import com.childdddd.libdrawalemaker.drawablekt.addGradient
import com.childdddd.libdrawalemaker.drawablekt.addStroke
import com.childdddd.libdrawalemaker.utils.Constants.GRADIENT_LINEAR
import com.childdddd.libdrawalemaker.utils.Constants.GRADIENT_RADIAL
import com.childdddd.libdrawalemaker.utils.Constants.GRADIENT_SWEEP
import com.childdddd.libdrawalemaker.utils.Constants.NONE
import com.childdddd.libdrawalemaker.utils.Constants.OVAL
import com.childdddd.libdrawalemaker.utils.Constants.RECTANGLE

/**
 * @Author Remiel
 * @Date 2023/9/27-11:37
 * @Describe: GradientDrawable属性
 */


/**
 * 圆角属性
 * @property radius     IntArray 圆角半径
 * @property solidColor Int 填充颜色
 * @constructor
 */
data class CornerProperty(
    var radius: IntArray,
    @ColorInt var solidColor: Int,
    @Shape var shape: Int = NONE,
    var useLevel: Boolean = false,
    override var level: Int = 10000,
) : BaseProperty(level) {

    override fun draw(drawable: Drawable) {
        super.draw(drawable)
        draw(drawable as GradientDrawable)

    }

    private fun draw(drawable: GradientDrawable) {
        drawable.addCorner(this)
    }
}

/**
 * 描边属性
 * @property stokeWith  Int     描边宽度
 * @property stokeColor Int     描边颜色
 * @property dashWidth  Float   虚线宽度
 * @property dashGap    Float   虚线间隔
 * @constructor
 */
data class StrokeProperty(
    var strokeWith: Int,
    @ColorInt var strokeColor: Int,
    var dashWidth: Float = 0F,
    var dashGap: Float = 0F,
    @Shape var shape: Int = NONE,
    var useLevel: Boolean = false,
    override var level: Int = 10000,
) : BaseProperty(level) {

    override fun draw(drawable: Drawable) {
        super.draw(drawable)
        draw(drawable as GradientDrawable)
    }

    private fun draw(drawable: GradientDrawable) {
        drawable.addStroke(this)
    }
}


/**
 * 渐变属性
 *
 * @property colors IntArray : 颜色渐变数组
 * @property orientation Orientation : 渐变方向
 *  orientation 即为在xml中的 android:angle 属性
 *  <p>这里有个坑，在xml中设置android:angle时，只有设置为以下值才能生效：</p>
 *  0, 45, 90, 135, 180, 225, 270, 315, 360
 *  与orientation 值对应关系为：
 *  0   = Orientation.LEFT_RIGHT
 *  45  = Orientation.BL_TR
 *  90  = Orientation.BOTTOM_TOP
 *  135 = Orientation.BR_TL
 *  180 = Orientation.RIGHT_LEFT
 *  225 = Orientation.TR_BL
 *  270 = Orientation.TOP_BOTTOM
 *  315 = Orientation.TL_BR
 *  设置上面的值以外的值时，会设置为默认值： 90， Orientation.BOTTOM_TOP
 *  @see [GradientDrawable.Orientation]
 *
 * @property gradientType Int： 渐变类型，取值范围
 * GradientDrawable.LINEAR_GRADIENT 线性渐变
 * GradientDrawable.RADIAL_GRADIENT 辐射渐变
 * GradientDrawable.SWEEP_GRADIENT 扫描渐变
 *
 * 当 gradientType = RADIAL_GRADIENT时，以下两个属性生效；否则不生效
 *
 *  另外，GradientDrawable中有以下几个方法：
 *  setTint()
 *  setTintList(ColorStateList)
 *  setTintMode(PorterDuff.Mode)
 *  setTintBlendMode(BlendMode)
 *  这几个方法都是设置着色器，但是在GradientDrawable中，只有setTint()方法生效，其他的方法都不生效(Copilot 说的，不知道对不对)
 *
 * @property gradientRadius Float： 辐射渐变半径
 * @property center Pair<Float, Float> ： 辐射渐变中心点比例
 * @constructor
 */

data class GradientProperty(
    var colors: IntArray,
    var orientation: GradientDrawable.Orientation,
    @GradientType var gradientType: Int = GRADIENT_LINEAR,
    var gradientRadius: Float = 0F,
    var center: Pair<Float, Float> = Pair(0.5F, 0.5F),
    @Shape var shape: Int = NONE,
    var useLevel: Boolean = false,
    override var level: Int = 10000,
) : BaseProperty(level) {

    override fun draw(drawable: Drawable) {
        super.draw(drawable)
        draw(drawable as GradientDrawable)
    }

    private fun draw(drawable: GradientDrawable) {
        drawable.addGradient(this)
    }
}


@IntDef(*[GRADIENT_LINEAR, GRADIENT_RADIAL, GRADIENT_SWEEP])
@Retention(
    AnnotationRetention.SOURCE
)
annotation class GradientType



@IntDef(*[NONE, RECTANGLE, OVAL])
@Retention(
    AnnotationRetention.SOURCE
)
annotation class Shape


