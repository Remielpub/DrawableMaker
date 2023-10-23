package com.childdddd.libdrawalemaker.builder

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import com.childdddd.libdrawalemaker.factory.PropertyFactory
import com.childdddd.libdrawalemaker.property.GradientType
import com.childdddd.libdrawalemaker.property.Shape
import com.childdddd.libdrawalemaker.utils.Constants
import com.childdddd.libdrawalemaker.utils.Constants.RECTANGLE
import com.childdddd.libdrawalemaker.utils.DrawableUtil.cornerRadius
import com.childdddd.libdrawalemaker.utils.parseColor

/**

 * @Author dangxiaohan
 * @Date 2023/10/17-11:09
 * @Describe
 */
class GradientDrawableBuilder: BaseBuilder() {

    /**
     * 创建 【纯色】属性的Drawable builder
     *
     * @param solidColor String        ：填充颜色，如 #000000
     *
     * @return GradientDrawableBuilder
     */
    fun withColor(solidColor: String): GradientDrawableBuilder {
        return withColor(parseColor(solidColor))
    }

    /**
     * 创建 【纯色】属性的Drawable builder
     *
     * @param solidColor Int       ：填充颜色，如 R.color.xxx 或 ColorInt
     *
     * @return GradientDrawableBuilder
     */
    fun withColor(solidColor: Int): GradientDrawableBuilder {
        return withColor(solidColor, RECTANGLE)
    }

    /**
     * 创建 【纯色】属性的Drawable builder

     * @param solidColor String         ：填充颜色，如 #000000
     *
     * @param shape Int                 ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     *
     * @return GradientDrawableBuilder
     */
    fun withColor(solidColor: String, @Shape shape: Int): GradientDrawableBuilder {
        return withColor(parseColor(solidColor) , shape)
    }

    /**
     * 创建 【纯色】属性的Drawable builder
     *
     * @param solidColor Int       ：填充颜色，如 R.color.xxx 或 ColorInt
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     * @return GradientDrawableBuilder
     */
    fun withColor(solidColor: Int, @Shape shape: Int): GradientDrawableBuilder {
        return withCorner(0, solidColor , shape)
    }

    /**
     * 创建 【圆角】属性的Drawable builder
     *
     * @param radius Int                ：圆角半径，单位dp
     * @return GradientDrawableBuilder
     */
    fun withCorner(radius: Int): GradientDrawableBuilder {
        return withCorner(radius, Color.TRANSPARENT)
    }

    /**
     * 创建 【圆角】属性的Drawable builder
     *
     * @param radius IntArray           ：四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @return GradientDrawableBuilder
     */
    fun withCorner(radius: IntArray): GradientDrawableBuilder {
        return withCorner(radius, Color.TRANSPARENT)
    }

    /**
     * 创建 【圆角】 【纯色】属性的Drawable builder
     *
     * @param radius Int        ：圆角半径，单位dp
     * @param solidColor String ：填充颜色，如 #000000
     *
     * @return GradientDrawableBuilder
     */
    fun withCorner(radius: Int, solidColor: String): GradientDrawableBuilder {
        return withCorner(radius, parseColor(solidColor))
    }

    /**
     * 创建 【圆角】 【纯色】属性的Drawable builder
     *
     * @param radius IntArray   ：四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor String ：填充颜色，如 #000000
     * @return GradientDrawableBuilder
     */
    fun withCorner(radius: IntArray, solidColor: String): GradientDrawableBuilder {
        return withCorner(radius, parseColor(solidColor))
    }

    /**
     * 创建 【圆角】 【纯色】属性的Drawable builder
     *
     * @param radius Int         ：圆角半径，单位dp
     * @param solidColor Int     ：填充颜色，如 R.color.xxx 或 ColorInt
     *
     * @return GradientDrawableBuilder
     */
    fun withCorner(radius: Int, solidColor: Int): GradientDrawableBuilder {
        return withCorner(radius, solidColor, RECTANGLE)
    }

    /**
     * 创建 【圆角】 【纯色】属性的Drawable builder
     *
     * @param radius IntArray         ：四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor Int          ：填充颜色，如 R.color.xxx 或 ColorInt
     *
     * @return GradientDrawableBuilder
     */
    fun withCorner(radius: IntArray, solidColor: Int): GradientDrawableBuilder {
        return withCorner(radius, solidColor, RECTANGLE)
    }

    /**
     * 创建 【圆角】 【纯色】 【形状】属性的Drawable builder
     *
     * @param radius Int        ：圆角半径，单位dp
     * @param solidColor Int    ：填充颜色，如 R.color.xxx 或 ColorInt
     * @param shape Int         ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     *
     * @return GradientDrawableBuilder
     */
    fun withCorner(radius: Int, solidColor: Int, @Shape shape: Int): GradientDrawableBuilder {
        return withCorner(cornerRadius(radius), solidColor, shape)
    }

    /**
     * 创建 【圆角】 【纯色】 【形状】属性的Drawable builder
     *
     * @param radius IntArray       ：四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor Int        ：填充颜色，如 R.color.xxx 或 ColorInt
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     *
     * @return GradientDrawableBuilder
     */
    fun withCorner(radius: IntArray, solidColor: Int, @Shape shape: Int): GradientDrawableBuilder {
        return withCorner(radius, solidColor, shape, false, 0)
    }

    /**
     * 创建 【圆角】 【纯色】 【形状】 【useLevel】属性的Drawable builder
     *
     * @param radius IntArray       ：四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
     * @param solidColor Int        ：填充颜色，如 R.color.xxx 或 ColorInt
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     * @param userLevel Boolean     ：是否使用level属性
     * @param level Int             ：level属性值
     *
     * @return GradientDrawableBuilder
     */
    fun withCorner(
        radius: IntArray,
        solidColor: Int,
        @Shape shape: Int,
        userLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): GradientDrawableBuilder {
        properties.add(
            PropertyFactory.cornerProperty(
                radius,
                solidColor,
                shape,
                userLevel,
                level
            )
        )
        return this
    }

    /**
     * 创建 【实线边框】属性的Drawable builder
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor String    ：边框颜色，如 #000000
     *
     * @return GradientDrawableBuilder
     */
    fun withStroke(strokeWidth: Int, strokeColor: String): GradientDrawableBuilder {
        return withStroke(strokeWidth, parseColor(strokeColor))
    }

    /**
     * 创建 【实线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor Int       ：边框颜色，如 R.color.xxx 或 ColorInt
     *
     * @return GradientDrawableBuilder
     */
    fun withStroke(strokeWidth: Int, strokeColor: Int): GradientDrawableBuilder {
        return withStroke(strokeWidth, strokeColor, RECTANGLE)
    }

    /**
     * 创建 【实线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor String    ：边框颜色，如 #000000
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     *
     * @return GradientDrawableBuilder
     */
    fun withStroke(strokeWidth: Int, strokeColor: String, @Shape shape: Int): GradientDrawableBuilder {
        return withStroke(strokeWidth, parseColor(strokeColor), shape)
    }

    /**
     * 创建 【实线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor Int       ：边框颜色，如 R.color.xxx 或 ColorInt
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     *
     * @return GradientDrawableBuilder
     */
    fun withStroke(strokeWidth: Int, strokeColor: Int, @Shape shape: Int): GradientDrawableBuilder {
        return withStroke(strokeWidth, strokeColor, shape, false, 0)
    }

    /**
     * 创建 【实线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor Int       ：边框颜色，如 R.color.xxx 或 ColorInt
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     * @param useLevel Boolean      ：是否使用level属性
     * @param level Int             ：level属性值
     *
     * @return GradientDrawableBuilder
     */
    fun withStroke(
        strokeWidth: Int,
        strokeColor: Int,
        @Shape shape: Int,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): GradientDrawableBuilder {
        properties.add(
            PropertyFactory.strokeProperty(
                strokeWidth,
                strokeColor,
                shape,
                useLevel,
                level
            )
        )
        return this
    }

    /**
     * 创建 【虚线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor String    ：边框颜色，如 #000000
     * @param dashWidth Float       ：虚线宽度，单位dp
     * @param dashGap Float         ：虚线间隔，单位dp
     *
     * @return GradientDrawableBuilder
     */
    fun withDash(
        strokeWidth: Int,
        strokeColor: String,
        dashWidth: Float,
        dashGap: Float
    ): GradientDrawableBuilder {
        return withDash(strokeWidth, parseColor(strokeColor) , dashWidth, dashGap)
    }

    /**
     * 创建 【虚线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor Int       ：边框颜色，如 R.color.xxx 或 ColorInt
     * @param dashWidth Float       ：虚线宽度，单位dp
     * @param dashGap Float         ：虚线间隔，单位dp
     *
     * @return GradientDrawableBuilder
     */
    fun withDash(
        strokeWidth: Int,
        @ColorInt strokeColor: Int,
        dashWidth: Float,
        dashGap: Float
    ): GradientDrawableBuilder {
        return withDash(strokeWidth, strokeColor, dashWidth, dashGap, RECTANGLE)
    }

    /**
     * 创建 【虚线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor String    ：边框颜色，如 #000000
     * @param dashWidth Float       ：虚线宽度，单位dp
     * @param dashGap Float         ：虚线间隔，单位dp
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     *
     * @return GradientDrawableBuilder
     */
    fun withDash(
        strokeWidth: Int,
        strokeColor: String,
        dashWidth: Float,
        dashGap: Float,
        @Shape shape: Int
    ): GradientDrawableBuilder {
        return withDash(
            strokeWidth,
            parseColor(strokeColor),
            dashWidth,
            dashGap,
            shape)
    }

    /**
     * 创建 【虚线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor Int       ：边框颜色，如 R.color.xxx 或 ColorInt
     * @param dashWidth Float       ：虚线宽度，单位dp
     * @param dashGap Float         ：虚线间隔，单位dp
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     * @return GradientDrawableBuilder
     */
    fun withDash(
        strokeWidth: Int,
        @ColorInt strokeColor: Int,
        dashWidth: Float,
        dashGap: Float,
        @Shape shape: Int
    ): GradientDrawableBuilder {
        return withDash(
            strokeWidth,
            strokeColor,
            dashWidth,
            dashGap,
            shape,
            false,
            0
        )
    }

    /**
     * 创建 【虚线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor String    ：边框颜色，如 #000000
     * @param dashWidth Float       ：虚线宽度，单位dp
     * @param dashGap Float         ：虚线间隔，单位dp
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     * @param useLevel Boolean      ：是否使用level属性
     * @param level Int             ：level属性值
     * @return GradientDrawableBuilder
     */
    fun withDash(
        strokeWidth: Int, strokeColor: String, dashWidth: Float, dashGap: Float,
        @Shape shape: Int = RECTANGLE,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): GradientDrawableBuilder {
        return withDash(
            strokeWidth,
            parseColor(strokeColor),
            dashWidth,
            dashGap,
            shape,
            useLevel,
            level
        )
    }

    /**
     * 创建 【虚线边框】属性的Drawable builder
     *
     * @param strokeWidth Int       ：边框宽度，单位dp
     * @param strokeColor Int       ：边框颜色，如 R.color.xxx 或 ColorInt
     * @param dashWidth Float       ：虚线宽度，单位dp
     * @param dashGap Float         ：虚线间隔，单位dp
     * @param shape Int             ：形状，如 [RECTANGLE]、[com.childdddd.libdrawalemaker.utils.Constants.OVAL]
     * @param useLevel Boolean      ：是否使用level属性
     * @param level Int             ：level属性值
     * @return GradientDrawableBuilder
     */
    fun withDash(
        strokeWidth: Int, @ColorInt strokeColor: Int, dashWidth: Float, dashGap: Float,
        @Shape shape: Int = RECTANGLE,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): GradientDrawableBuilder {
        properties.add(
            PropertyFactory.dashProperty(
                strokeWidth,
                strokeColor,
                dashWidth,
                dashGap,
                shape,
                useLevel,
                level
            )
        )
        return this
    }

    /**
     * 创建 【渐变】属性的Drawable builder
     *
     * @param colors IntArray           ：渐变颜色数组
     * @param orientation Orientation   ：渐变方向
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
     *
     * @return GradientDrawableBuilder
     */
    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
    ): GradientDrawableBuilder {
        return withGradient(
            colors,
            orientation,
            shape = RECTANGLE
        )
    }

    /**
     * 创建 【渐变】属性的Drawable builder
     *
     * @param colors IntArray           ：渐变颜色数组
     * @param orientation Orientation   ：渐变方向
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
     *
     * @param shape Int                 ：渐变形状，支持矩形、椭圆
     * @return GradientDrawableBuilder
     */
    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
        @Shape shape: Int,
    ): GradientDrawableBuilder {
        return withGradient(
            colors,
            orientation,
            shape,
            Constants.GRADIENT_LINEAR,
            0F,
            Pair(0.5F, 0.5F)
        )
    }

    /**
     * 创建 【渐变】属性的Drawable builder
     *
     * @param colors IntArray           ：渐变颜色数组
     * @param orientation Orientation   ：渐变方向
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
     *
     * @param shape Int                 ：渐变形状，支持矩形、椭圆
     * @param gradientType Int          ：渐变类型，支持线性渐变、径向(雷达)渐变、扫描渐变
     *
     * @return GradientDrawableBuilder
     */
    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
        @Shape shape: Int,
        @GradientType gradientType: Int,
    ): GradientDrawableBuilder {
        return withGradient(
            colors,
            orientation,
            shape,
            gradientType,
            0F,
            Pair(0.5F, 0.5F)
        )
    }

    /**
     * 创建 【渐变】属性的Drawable builder
     *
     * @param colors IntArray           ：渐变颜色数组
     * @param orientation Orientation   ：渐变方向
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
     *
     * @param shape Int                 ：渐变形状，支持矩形、椭圆
     * @param gradientType Int          ：渐变类型，支持线性渐变、径向(雷达)渐变、扫描渐变
     * @param useLevel Boolean          ：是否使用level属性
     * @param level Int                 ：level属性值
     *
     * @return GradientDrawableBuilder
     */
    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
        @Shape shape: Int,
        @GradientType gradientType: Int,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): GradientDrawableBuilder {
        return withGradient(
            colors,
            orientation,
            shape,
            gradientType,
            0F,
            Pair(0.5F, 0.5F),
            useLevel,
            level
        )
    }

    /**
     * 创建 【渐变】属性的Drawable builder
     *
     * @param colors IntArray           ：渐变颜色数组
     * @param orientation Orientation   ：渐变方向
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
     *
     * @param shape Int                 ：渐变形状，支持矩形、椭圆
     * @param gradientType Int          ：渐变类型，支持线性渐变、径向(雷达)渐变、扫描渐变
     * @param gradientRadius Float      ：渐变半径，仅在渐变类型为径向渐变时有效
     * @param center Pair<Float, Float> ：渐变中心点，仅在渐变类型为径向渐变时有效
     *
     * @return GradientDrawableBuilder
     */
    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
        @Shape shape: Int,
        @GradientType gradientType: Int,
        gradientRadius: Float,
        center: Pair<Float, Float>,
    ): GradientDrawableBuilder {
        return withGradient(
            colors,
            orientation,
            shape,
            gradientType,
            gradientRadius,
            center,
            false,
            0
        )
    }

    /**
     * 创建 【渐变】属性的Drawable builder
     *
     * @param colors IntArray           ：渐变颜色数组
     * @param orientation Orientation   ：渐变方向
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
     *
     * @param shape Int                 ：渐变形状，支持矩形、椭圆
     * @param gradientType Int          ：渐变类型，支持线性渐变、径向(雷达)渐变、扫描渐变
     * @param gradientRadius Float      ：渐变半径，仅在渐变类型为径向渐变时有效
     * @param center Pair<Float, Float> ：渐变中心点，仅在渐变类型为径向渐变时有效
     * @param useLevel Boolean          ：是否使用level属性
     * @param level Int                 ：level属性值
     *
     * @return GradientDrawableBuilder
     */
    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
        @Shape shape: Int,
        @GradientType gradientType: Int,
        gradientRadius: Float = 0F,
        center: Pair<Float, Float> = Pair(0.5F, 0.5F),
        useLevel: Boolean = false,
        level: Int = 10000,
    ): GradientDrawableBuilder {
        properties.add(
            PropertyFactory.gradientProperty(
                colors,
                orientation,
                gradientType,
                gradientRadius,
                center,
                shape,
                useLevel,
                level
            )
        )
        return this
    }

    override fun createDrawable(): GradientDrawable {
       return GradientDrawable()
    }
}
