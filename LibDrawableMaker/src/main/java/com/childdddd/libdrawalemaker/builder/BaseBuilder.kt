package com.childdddd.libdrawalemaker.builder

import android.graphics.drawable.Drawable
import com.childdddd.libdrawalemaker.property.BaseProperty

/**

 * @Author dangxiaohan
 * @Date 2023/10/17-10:59
 * @Describe
 */
abstract class BaseBuilder {
    protected val properties = mutableListOf<BaseProperty>()

    fun make(): Drawable {
        val drawable = createDrawable()
        properties.forEach {
            it.draw(drawable)
        }
        return drawable
    }

    protected abstract fun createDrawable(): Drawable
}
