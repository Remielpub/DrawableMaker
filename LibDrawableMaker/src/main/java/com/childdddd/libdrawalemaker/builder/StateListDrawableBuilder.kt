package com.childdddd.libdrawalemaker.builder

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import com.childdddd.libdrawalemaker.factory.PropertyFactory
import com.childdddd.libdrawalemaker.utils.Constants.INDEX_CHECKED
import com.childdddd.libdrawalemaker.utils.Constants.INDEX_ENABLED
import com.childdddd.libdrawalemaker.utils.Constants.INDEX_FOCUSED
import com.childdddd.libdrawalemaker.utils.Constants.INDEX_PRESSED
import com.childdddd.libdrawalemaker.utils.Constants.INDEX_SELECTED
import com.childdddd.libdrawalemaker.utils.DrawableUtil

/**
 * @Author dangxiaohan
 * @Date 2023/10/17-16:49
 * @Describe: Selector Drawable 创建Builder
 */
class StateListDrawableBuilder : BaseBuilder() {

    /**
     * 创建 state_selected 属性的Drawable builder
     *
     * @param normal Int：正常状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     * @param active Int：选中状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     *
     * @return StateListDrawableBuilder
     */
    fun withSelected(normal: Int, active: Int): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normal, active)
        return withSelected(drawables[0], drawables[1])
    }

    /**
     * 创建 state_selected 属性的Drawable builder
     *
     * @param normalColor String：正常状态颜色， 如 #xxxxxx
     * @param activeColor String：选中状态颜色， 如 #xxxxxx
     *
     * @return StateListDrawableBuilder
     */
    fun withSelected(normalColor: String, activeColor: String): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normalColor, activeColor)
        return withSelected(drawables[0], drawables[1])
    }

    /**
     * 创建 state_selected 属性的Drawable builder
     *
     * @param normal Drawable
     * @param active Drawable
     * @return StateListDrawableBuilder
     */
    fun withSelected(normal: Drawable, active: Drawable): StateListDrawableBuilder {
        properties.add(PropertyFactory.stateProperty(INDEX_SELECTED, normal, active))
        return this
    }

    /**
     * 创建 state_enabled 属性的Drawable builder
     *
     * @param normal Int：正常状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     * @param active Int：选中状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     *
     * @return StateListDrawableBuilder
     */
    fun withEnabled(normal: Int, active: Int): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normal, active)
        return withEnabled(drawables[0], drawables[1])
    }

    /**
     * 创建 state_enabled 属性的Drawable builder
     *
     * @param normalColor String：正常状态颜色， 如 #xxxxxx
     * @param activeColor String：选中状态颜色， 如 #xxxxxx
     *
     * @return StateListDrawableBuilder
     */
    fun withEnabled(normal: String, active: String): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normal, active)
        return withEnabled(drawables[0], drawables[1])
    }

    /**
     * 创建 state_enabled 属性的Drawable builder
     *
     * @param normal Drawable
     * @param active Drawable
     *
     * @return StateListDrawableBuilder
     */
    fun withEnabled(normal: Drawable, active: Drawable): StateListDrawableBuilder {
        properties.add(PropertyFactory.stateProperty(INDEX_ENABLED, normal, active))
        return this
    }

    /**
     * 创建 state_pressed 属性的Drawable builder
     *
     * @param normal Int：正常状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     * @param active Int：选中状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     *
     * @return StateListDrawableBuilder
     */
    fun withPressed(normal: Int, active: Int): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normal, active)
        return withPressed(drawables[0], drawables[1])
    }

    /**
     * 创建 state_pressed 属性的Drawable builder
     *
     * @param normalColor String：正常状态颜色， 如 #xxxxxx
     * @param activeColor String：选中状态颜色， 如 #xxxxxx
     *
     * @return StateListDrawableBuilder
     */
    fun withPressed(normalColor: String, activeColor: String): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normalColor, activeColor)
        return withPressed(drawables[0], drawables[1])
    }

    /**
     * 创建 state_pressed 属性的Drawable builder
     *
     * @param normal Drawable
     * @param active Drawable
     *
     * @return StateListDrawableBuilder
     */
    fun withPressed(normal: Drawable, active: Drawable): StateListDrawableBuilder {
        properties.add(PropertyFactory.stateProperty(INDEX_PRESSED, normal, active))
        return this
    }

    /**
     * 创建 state_checked 属性的Drawable builder
     *
     * @param normal Int：正常状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     * @param active Int：选中状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     *
     * @return StateListDrawableBuilder
     */
    fun withChecked(normal: Int, active: Int): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normal, active)
        return withChecked(drawables[0], drawables[1])
    }

    /**
     * 创建 state_checked 属性的Drawable builder
     *
     * @param normalColor String：正常状态颜色， 如 #xxxxxx
     * @param activeColor String：选中状态颜色， 如 #xxxxxx
     *
     * @return StateListDrawableBuilder
     */
    fun withChecked(normalColor: String, activeColor: String): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normalColor, activeColor)
        return withChecked(drawables[0], drawables[1])
    }

    /**
     * 创建 state_checked 属性的Drawable builder
     *
     * @param normal Drawable
     * @param active Drawable
     *
     * @return StateListDrawableBuilder
     */
    fun withChecked(normal: Drawable, active: Drawable): StateListDrawableBuilder {
        properties.add(PropertyFactory.stateProperty(INDEX_CHECKED, normal, active))
        return this
    }

    /**
     * 创建 state_focused 属性的Drawable builder
     *
     * @param normal Int：正常状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     * @param active Int：选中状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     *
     * @return StateListDrawableBuilder
     */
    fun withFocused(normal: Int, active: Int): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normal, active)
        return withChecked(drawables[0], drawables[1])
    }

    /**
     * 创建 state_focused 属性的Drawable builder
     *
     * @param normalColor String：正常状态颜色， 如 #xxxxxx
     * @param activeColor String：选中状态颜色， 如 #xxxxxx
     *
     * @return StateListDrawableBuilder
     */
    fun withFocused(normalColor: String, activeColor: String): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normalColor, activeColor)
        return withChecked(drawables[0], drawables[1])
    }

    /**
     * 创建 state_focused 属性的Drawable builder
     *
     * @param normal Drawable
     * @param active Drawable
     *
     * @return StateListDrawableBuilder
     */
    fun withFocused(normal: Drawable, active: Drawable): StateListDrawableBuilder {
        properties.add(PropertyFactory.stateProperty(INDEX_FOCUSED, normal, active))
        return this
    }

    /**
     *
     * @param type Int: 状态类型
     * [INDEX_SELECTED] : 选中状态, 0
     * [INDEX_ENABLED]  : 使能状态, 1
     * [INDEX_PRESSED]  : 按下状态, 2
     * [INDEX_CHECKED]  : 勾选状态, 3
     * [INDEX_FOCUSED]  : 聚焦状态, 4
     * 这里将以上常用的状态类型封装成了常量，也可以直接使用[android.R.attr.DrawableStates]中的其他属性，
     * 如 withState(android.R.attr.state_hovered, R.color.xxx, R.color.xxx)
     *
     * @param normal Int：正常状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     * @param active Int：选中状态下的drawable， 支持R.drawable.xxx, R.mipmap.xxx, R.color.xxx 与 ColorInt
     * @return StateListDrawableBuilder
     */
    fun withState(type: Int, normal: Int, active: Int): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normal, active)
        return withState(type, drawables[0], drawables[1])
    }

    /**
     *
     * @param type Int
     * @param normalColor String
     * @param activeColor String
     * @return StateListDrawableBuilder
     */
    fun withState(type: Int, normalColor: String, activeColor: String): StateListDrawableBuilder {
        val drawables = DrawableUtil.convertDrawable(normalColor, activeColor)
        return withState(type, drawables[0], drawables[1])
    }

    fun withState(type: Int, normal: Drawable, active: Drawable): StateListDrawableBuilder {
        properties.add(PropertyFactory.stateProperty(type, normal, active))
        return this
    }

    override fun createDrawable(): Drawable {
        return StateListDrawable()
    }
}
