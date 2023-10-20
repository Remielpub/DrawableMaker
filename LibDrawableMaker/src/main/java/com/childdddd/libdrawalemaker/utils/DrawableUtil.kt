package com.childdddd.libdrawalemaker.utils

import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat



/**
 * @Author dangxiaohan
 * @Date 2023/10/20-10:49
 * @Describe： 资源转换 & 数据转换工具类
 */
object DrawableUtil {
    /**
     * 获取Drawable 或 Mipmap 资源
     *
     * @param id Int
     * @return Drawable?
     */
    @JvmStatic
    fun getDrawable(id: Int): Drawable? {
        try {
            return ContextCompat.getDrawable(Utils.getApp(), id)
        } catch (_: Resources.NotFoundException) {

        }
        return null
    }

    /**
     * 获取颜色资源
     *
     * @param id Int
     * @return Int
     */
    @JvmStatic
    fun getColor(id: Int): Int {
        try {
            return ContextCompat.getColor(Utils.getApp(), id)
        } catch (_: Resources.NotFoundException) {

        }
        return -1
    }

    /**
     * 将颜色值（ColorInt） 或 R.color.xxx 转换为Drawable
     *
     * @param id Int
     * @return Drawable?
     */
    @JvmStatic
    fun getColorDrawable(id: Int): Drawable? {
        if (id == 0) return null
        var colorInt = getColor(id)

        if (colorInt == -1) {
            colorInt = id
        }
        return ColorDrawable(colorInt)
    }

    /**
     * 将 R.color.xxx 或者 R.drawable.xxx / R.mipmap.xxx 转换为Drawable
     * drawable 与 mipmap 使用[getDrawable]获取
     *
     * 先判断是否为Drawable，如果不是再判断是否为Color
     *
     * @param res Int
     * @return Drawable?
     */
    @JvmStatic
    fun checkAndCreateDrawable(res: Int): Drawable? {
        var drawable: Drawable? = null
        drawable = getDrawable(res)
        if (drawable == null) {
            drawable = getColorDrawable(res)
        }
        return drawable
    }

    /**
     * 创建圆角数组转换方法
     *
     * @param r IntArray
     * @return IntArray
     */
    @JvmStatic
    fun cornerRadius(vararg  r: Int): IntArray {
        val radius = IntArray(4) { 0 }
        when (r.size) {
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

            else -> {
                radius[0] = r[0]
                radius[1] = r[1]
                radius[2] = r[2]
                radius[3] = r[3]
            }
        }
        return radius
    }

    /**
     * 生成颜色数据
     *
     * @param colors IntArray
     * @return IntArray
     */
    @JvmStatic
    fun colors(vararg colors: Int): IntArray {
        return colors
    }

    /**
     * 生成坐标工具方法
     *
     * @param x Float
     * @param y Float
     * @return Pair<Float, Float>
     */
    @JvmStatic
    fun center(x: Float, y: Float): Pair<Float, Float> {
        return Pair(x, y)
    }

    /**
     * 将资源值 转换为Drawable
     *
     * @param normal Int
     * @param active Int
     * @return Array<Drawable>
     */
    @JvmStatic
    fun convertDrawable(normal: Int, active: Int): Array<Drawable> {
        val normalDrawable = checkAndCreateDrawable(normal)
        val activeDrawable = checkAndCreateDrawable(active)

        if (normalDrawable == null || activeDrawable == null) {
            throw Resources.NotFoundException("${if (normalDrawable == null) "normal" else "active"} res is not found")
        }
        return arrayOf(
            normalDrawable, activeDrawable
        )
    }

    @JvmStatic
    fun convertDrawable(normal: String, active: String): Array<Drawable> {
        val normalDrawable = ColorDrawable(parseColor(normal))
        val activeDrawable = ColorDrawable(parseColor(active))
        return arrayOf(
            normalDrawable, activeDrawable
        )
    }
}
