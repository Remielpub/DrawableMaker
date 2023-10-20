package com.childdddd.libdrawalemaker.property

import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import com.childdddd.libdrawalemaker.drawablekt.addState
import com.childdddd.libdrawalemaker.utils.Constants.PROPERTY_CHECKED
import com.childdddd.libdrawalemaker.utils.Constants.PROPERTY_ENABLED
import com.childdddd.libdrawalemaker.utils.Constants.PROPERTY_FOCUSED
import com.childdddd.libdrawalemaker.utils.Constants.PROPERTY_PRESSED
import com.childdddd.libdrawalemaker.utils.Constants.PROPERTY_SELECTED

/**

 * @Author Remiel
 * @Date 2023/9/27-11:40
 * @Describe
 */

data class StateProperty2(val type: Int, val normal: Drawable, val active: Drawable): BaseProperty() {

    override fun draw(drawable: Drawable) {
        super.draw(drawable)
        val stateType =
            if (type >= 0 && type < PROPERTYS.size)
                PROPERTYS[type]
            else
                type

        (drawable as StateListDrawable).addState(stateType, normal, active)
    }

    companion object {
        internal val PROPERTYS = arrayOf(
            PROPERTY_SELECTED,
            PROPERTY_ENABLED,
            PROPERTY_PRESSED,
            PROPERTY_CHECKED,
            PROPERTY_FOCUSED
        )
    }
}
