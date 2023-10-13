package com.childdddd.libdrawalemaker

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import com.childdddd.libdrawalemaker.factory.PropertyFactory
import com.childdddd.libdrawalemaker.property.BaseProperty
import com.childdddd.libdrawalemaker.property.CornerProperty
import com.childdddd.libdrawalemaker.property.GradientType
import com.childdddd.libdrawalemaker.property.Shape
import com.childdddd.libdrawalemaker.property.StrokeProperty

/**
 * @Author dangxiaohan
 * @Date 2023/10/12-11:26
 * @Describe
 */
class DrawableMaker constructor(private val properties: List<BaseProperty>) {

    fun make(): Drawable {
        val drawable = GradientDrawable()
        properties.forEach {
            if (it is CornerProperty) {
                it.draw(drawable)
            } else if (it is StrokeProperty) {
                it.draw(drawable)
            }
        }
        return drawable
    }

    companion object {
        @JvmStatic
        fun get(): Builder {
            return Builder()
        }
    }
}

class Builder {
    private val properties = mutableListOf<BaseProperty>()

//    fun with(property: CornerProperty): Builder {
//        properties.add(property)
//        return this
//    }
//
//    fun with(property: StrokeProperty): Builder {
//        properties.add(property)
//        return this
//    }

    fun make(): Drawable {
        return DrawableMaker(properties).make()
    }

    fun withCorner(radius: Int, solidColor: String): Builder {
        return withCorner(radius, solidColor, GradientDrawable.RECTANGLE)
    }

    fun withCorner(radius: Int, solidColor: String, @Shape shape: Int): Builder {
        return withCorner(radius, solidColor, shape, false, 0)
    }

    fun withCorner(
        radius: Int,
        solidColor: String,
        @Shape shape: Int,
        userLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): Builder {
        properties.add(
            PropertyFactory.cornerProperty(
                intArrayOf(radius),
                solidColor,
                shape,
                userLevel,
                level
            )
        )
        return this
    }

    fun withStroke(strokeWidth: Int, strokeColor: String): Builder {
        return withStroke(strokeWidth, strokeColor, GradientDrawable.RECTANGLE)
    }

    fun withStroke(strokeWidth: Int, strokeColor: String, @Shape shape: Int): Builder {
        return withStroke(strokeWidth, strokeColor, shape, false, 0)
    }

    fun withStroke(
        strokeWidth: Int,
        strokeColor: String,
        @Shape shape: Int,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): Builder {
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

    fun withDash(
        strokeWidth: Int,
        @ColorInt strokeColor: Int,
        dashWidth: Float,
        dashGap: Float
    ): Builder {
        return withDash(strokeWidth, strokeColor, dashWidth, dashGap, GradientDrawable.RECTANGLE)
    }

    fun withDash(
        strokeWidth: Int,
        @ColorInt strokeColor: Int,
        dashWidth: Float,
        dashGap: Float,
        @Shape shape: Int
    ): Builder {
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

    fun withDash(
        strokeWidth: Int, @ColorInt strokeColor: Int, dashWidth: Float, dashGap: Float,
        @Shape shape: Int = GradientDrawable.RECTANGLE,
        useLevel: Boolean,
        @IntRange(from = 0, to = 10000) level: Int
    ): Builder {
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

    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
        @Shape shape: Int,
    ): Builder {
        return withGradient(
            colors,
            orientation,
            shape,
            GradientDrawable.LINEAR_GRADIENT,
            0F,
            Pair(0.5F, 0.5F)
        )
    }

    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
        @Shape shape: Int,
        @GradientType gradientType: Int,
        gradientRadius: Float,
        center: Pair<Float, Float>,
    ): Builder {
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

    fun withGradient(
        colors: IntArray,
        orientation: GradientDrawable.Orientation,
        @Shape shape: Int,
        @GradientType gradientType: Int,
        gradientRadius: Float = 0F,
        center: Pair<Float, Float> = Pair(0.5F, 0.5F),
        useLevel: Boolean = false,
        level: Int = 10000,
    ): Builder {
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
}

