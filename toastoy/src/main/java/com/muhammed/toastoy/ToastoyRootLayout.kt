package com.muhammed.toastoy

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView

/**
 * Root of the toast layout.
 *
 * A toast window is WRAP_CONTENT, and for such windows the framework first measures the
 * view against a fixed "preferred dialog width" (320dp on phones) and only widens it when
 * the view reports [MEASURED_STATE_TOO_SMALL]. Without this, long messages wrap early and
 * hit the line limit while there is still free space on the screen.
 *
 * This layout flags TOO_SMALL whenever the message had to wrap and its TextView has not yet
 * reached its own `maxWidth`, so the toast grows to the screen width before it starts wrapping.
 */
internal class ToastoyRootLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.AT_MOST) return
        val text = findViewById<TextView>(R.id.toastoy_text) ?: return
        val wrapped = (text.layout?.lineCount ?: 0) > 1
        val canGrow = text.measuredWidth < text.maxWidth
        if (wrapped && canGrow) {
            setMeasuredDimension(
                measuredWidthAndState or MEASURED_STATE_TOO_SMALL,
                measuredHeightAndState
            )
        }
    }
}
