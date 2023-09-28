package com.childdddd.libdrawalemaker.utils

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import com.childdddd.libdrawalemaker.drawablekt.addCorners
import com.childdddd.libdrawalemaker.drawablekt.addStroke
import com.childdddd.libdrawalemaker.property.CornerProperty
import com.childdddd.libdrawalemaker.property.StokeProperty

/**

 * @Author Remiel
 * @Date 2023/9/18-16:01
 * @Describe
 */
object GradientDrawableUtil {
        /**
         * 圆角角度数组生成:
         *
         * 参数size =  1       : 统一设置四个角的圆角大小
         * 参数size >  1 & < 4 : 按照左上、右上、右下、左下的顺序设置圆角大小, 不足四个值,其余值取0
         * 参数size >= 4       : 只取前四个值,按照左上、右上、右下、左下的顺序设置圆角大小
         * @param r IntArray
         * @return IntArray
         */
        @JvmStatic
        fun cornerRadius(vararg r: Int): IntArray {
            val radius = IntArray(4){ 0 }
            when(r.size) {
                0 -> {

                }
                1 -> {
                    radius[0] = r[0]
                    radius[1] = r[0]
                    radius[2] = r[0]
                    radius[3] = r[0]
                }
                2 -> {
                    radius[0] = r[0]
                    radius[1] = r[1]
                }
                3 -> {
                    radius[0] = r[0]
                    radius[1] = r[1]
                    radius[2] = r[2]
                }
                else ->{
                    radius[0] = r[0]
                    radius[1] = r[1]
                    radius[2] = r[2]
                    radius[3] = r[3]
                }
            }
            return radius
        }

        /**
         * 四个角 圆角大小相同 的 Drawable 生成属性，
         *
         * @param radius Int : 圆角大小，单位dp,
         * @return CornerProperty
         */
        @JvmStatic
        fun  addCorners(radius: Int): CornerProperty {
            return CornerProperty(cornerRadius(radius), -1)
        }

        /**
         * 四个角的圆角大小不同 的 Drawable 生成属性
         *
         * @param radius IntArray: 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
         * @return CornerProperty
         */
        @JvmStatic
        fun  addCorners(radius: IntArray): CornerProperty {
            return CornerProperty(radius, -1)
        }

        /**
         * 四个角 圆角角度 不同 & 背景颜色 Drawable 生成属性
         *
         * @param radius     IntArray : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
         * @param solidColor Int      : 填充颜色, ColorInt
         * @return CornerProperty
         */
        @JvmStatic
        fun addCorners(radius: IntArray, @ColorInt solidColor: Int): CornerProperty {
            return CornerProperty(radius, solidColor)
        }

        /**
         * 四个角 圆角角度 相同 & 背景颜色 Drawable 生成属性
         *
         * @param radius     Int      : 圆角大小，单位dp,
         * @param solidColor Int      : 填充颜色, ColorInt
         * @return CornerProperty
         */
        @JvmStatic
        fun addCorners(radius: Int, @ColorInt solidColor: Int): CornerProperty {
            return CornerProperty(cornerRadius(radius), solidColor)
        }

        /**
         * 四个角 圆角角度 不同 & 背景颜色 Drawable 生成属性
         *
         * @param radius     IntArray : 四个角的圆角大小，单位dp, 可以使用[cornerRadius]方法转换
         * @param solidColor String   : 填充颜色, 颜色值，如 #000000
         * @return CornerProperty
         */
        @JvmStatic
        fun addCorners(radius: IntArray, solidColor: String): CornerProperty {
            return CornerProperty(radius, Color.parseColor(solidColor))
        }

        /**
         * 虚线边框 Drawable 生成属性
         *
         * @param stokeWith Int      : 虚线宽度，单位dp
         * @param stokeColor Int     : 虚线颜色，ColorInt
         * @param dashWidth Float    : 单条虚线长度，单位dp
         * @param dashGap Float      : 虚线间隔，单位dp
         * @return StokeProperty
         */
        @JvmStatic
        fun addDash(stokeWith: Int, @ColorInt stokeColor: Int, dashWidth: Float = 0F, dashGap: Float = 0F): StokeProperty {
            return StokeProperty(stokeWith, stokeColor, dashWidth, dashGap)
        }

        /**
         * 虚线边框 Drawable 生成属性
         *
         * @param stokeWith Int     : 虚线宽度，单位dp
         * @param stokeColor String : 虚线颜色，颜色值，如 #000000
         * @param dashWidth Float   : 单条虚线长度，单位dp
         * @param dashGap Float     : 虚线间隔，单位dp
         * @return StokeProperty
         */
        @JvmStatic
        fun addDash(stokeWith: Int, stokeColor: String, dashWidth: Float = 0F, dashGap: Float = 0F): StokeProperty {
            return StokeProperty(stokeWith, parseColor(stokeColor), dashWidth, dashGap)
        }

        /**
         * 实线边框 Drawable 生成属性
         *
         * @param stokeWith Int     : 边框宽度，单位dp
         * @param stokeColor Int    : 边框颜色，ColorInt
         * @return StokeProperty
         */
        @JvmStatic
        fun addStroke(stokeWith: Int, @ColorInt stokeColor: Int): StokeProperty {
            return StokeProperty(stokeWith, stokeColor)
        }

        /**
         * 实线边框 Drawable 生成属性
         *
         * @param stokeWith Int     : 边框宽度，单位dp
         * @param stokeColor String : 边框颜色，颜色值，如 #000000
         * @return StokeProperty
         */
        @JvmStatic
        fun addStroke(stokeWith: Int, stokeColor: String): StokeProperty {
            return StokeProperty(stokeWith, parseColor(stokeColor))
        }

        /**
         * 生成 圆角背景 & 描边 Drawable
         *
         * @param corners CornerProperty? : 圆角及背景属性值
         * @param stroke  StokeProperty?  : 描边属性值
         */
        @JvmStatic
        fun drawable(corners: CornerProperty?, stroke: StokeProperty?):Drawable {
            return GradientDrawable().apply {
                //设置圆角
                corners?.let {
                    addCorners(it.radius)
                    //设置drawable 颜色
                    if (it.solidColor != -1) {
                        setColor(it.solidColor)
                    }
                }

                //添加描边
                stroke?.let {
                    addStroke(it.stokeWith, it.stokeColor, it.dashWidth, it.dashGap)
                }
            }
        }

        /**
         * 生成 相同圆角 Drawable
         *
         * @param radius Int
         */
        @JvmStatic
        fun drawable(radius: Int) {
            return drawable(cornerRadius(radius))
        }

        /**
         * 生成 圆角不同 Drawable
         *
         * 圆角数组生成方法 [cornerRadius]
         *
         * @param radius IntArray
         */
        @JvmStatic
        fun drawable(radius: IntArray) {
            return drawable(radius)
        }

        /**
         * 生成 相同圆角 & 背景颜色 的Drawable
         *
         * @param radius     Int    : 圆角大小，单位dp
         * @param solidColor Int    : 填充颜色, ColorInt
         * @return Drawable
         */
        @JvmStatic
        fun drawable(radius: Int, @ColorInt solidColor: Int): Drawable {
            return drawable(cornerRadius(radius), solidColor)
        }

        /**
         * 生成 相同圆角 & 背景颜色 的Drawable
         *
         * @param radius        Int     : 圆角大小，单位dp
         * @param solidColorStr String  : 填充颜色, String
         * @return Drawable
         */
        @JvmStatic
        fun drawable(radius: Int, solidColorStr: String): Drawable {
            return drawable(radius, parseColor(solidColorStr))
        }

        /**
         * 生成 圆角不同 & 背景颜色 的Drawable
         *
         * @param radius     IntArray   : 圆角大小，单位dp
         * @param solidColor Int        : 填充颜色, ColorInt
         * @return Drawable
         */
        @JvmStatic
        fun drawable(radius: IntArray, @ColorInt solidColor: Int): Drawable {
            return drawable(radius, solidColor, 0, Color.TRANSPARENT)
        }

        /**
         * 生成 圆角不同 & 背景颜色 的Drawable
         * @param radius        IntArray    : 圆角大小，单位dp
         * @param solidColorStr String      : 填充颜色, String
         * @return Drawable
         */
        @JvmStatic
        fun drawable(radius: IntArray, solidColorStr: String): Drawable {
            return drawable(radius, parseColor(solidColorStr))
        }

        /**
         * 生成 圆角相同 & 背景颜色 & 边框的Drawable
         *
         * @param radius        Int     : 圆角大小，单位dp
         * @param solidColor    Int     : 填充颜色, ColorInt
         * @param strokeWitdh   Int     : 边框宽度，单位dp
         * @param strokeColor   Int     : 边框颜色, ColorInt
         * @return Drawable
         */
        @JvmStatic
        fun drawable(radius: Int, @ColorInt solidColor: Int, strokeWitdh: Int, @ColorInt strokeColor: Int): Drawable {
            return drawable(cornerRadius(radius), solidColor, strokeWitdh, strokeColor)
        }

        /**
         * 生成 圆角相同 & 背景颜色 & 边框的Drawable
         *
         * @param radius         Int        : 圆角大小，单位dp
         * @param solidColor     String     : 填充颜色, String
         * @param strokeWitdh    Int        : 边框宽度，单位dp
         * @param strokeColor    String     : 边框颜色, String
         * @return Drawable
         */
        @JvmStatic
        fun drawable(radius: Int, solidColor: String, strokeWitdh: Int, strokeColor: String): Drawable {
            return drawable(radius, parseColor(solidColor), strokeWitdh, parseColor(strokeColor))
        }

        /**
         * 生成 圆角不同 & 背景颜色 & 边框的Drawable
         *
         * @param radius         IntArray   : 圆角大小，单位dp
         * @param solidColor     Int        : 填充颜色, ColorInt
         * @param strokeWitdh    Int        : 边框宽度，单位dp
         * @param strokeColor    Int        : 边框颜色, ColorInt
         * @return Drawable
         */
        @JvmStatic
        fun drawable(radius: IntArray, @ColorInt solidColor: Int, strokeWitdh: Int, @ColorInt strokeColor: Int): Drawable {
            return drawable(radius, solidColor, strokeWitdh, strokeColor, 0f, 0f)
        }

        /**
         * 生成 圆角不同 & 背景颜色 & 虚线边框的Drawable
         *
         * @param radius      IntArray?  : 圆角大小，单位dp
         * @param solidColor  String     : 填充颜色, String
         * @param strokeWitdh Int        : 边框宽度，单位dp
         * @param strokeColor String     : 边框颜色, String
         * @param dashWidth   Float      : 虚线宽度，单位dp
         * @param dashGap     Float      : 虚线间隔，单位dp
         */
        @JvmStatic
        fun drawable(
            radius: IntArray?,
            solidColor: String?,
            strokeWitdh: Int,
            strokeColor: String?,
            dashWidth: Float,
            dashGap: Float
        ): Drawable {

            val internalSolidColor = parseColor(solidColor ?: "")

            val internalstrokeColor = parseColor(strokeColor ?: "")

            return drawable(radius, internalSolidColor, strokeWitdh, internalstrokeColor, dashWidth, dashGap)
        }

        /**
         * 生成 圆角不同 & 背景颜色 & 虚线边框的Drawable
         *
         * @param radius      IntArray?  : 圆角大小，单位dp
         * @param solidColor  Int        : 填充颜色, ColorInt
         * @param strokeWitdh Int        : 边框宽度，单位dp
         * @param strokeColor Int        : 边框颜色, ColorInt
         * @param dashWidth   Float      : 虚线宽度，单位dp
         * @param dashGap     Float      : 虚线间隔，单位dp
         */
        @JvmStatic
        fun drawable(
            radius: IntArray?,
            @ColorInt solidColor: Int,
            strokeWitdh: Int,
            @ColorInt strokeColor: Int,
            dashWidth: Float,
            dashGap: Float
        ): Drawable {
            return GradientDrawable().apply {
                //设置圆角
                radius?.let {
                    addCorners(it)
                }
                //添加描边
                addStroke(strokeWitdh, strokeColor, dashWidth, dashGap)

                //设置drawable 颜色
                setColor(solidColor)
            }
        }
    }
