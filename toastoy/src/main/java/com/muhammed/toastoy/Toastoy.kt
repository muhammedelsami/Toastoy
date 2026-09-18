package com.muhammed.toastoy

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat.getColor

/**
 * Created by Muhammed Elşami on 14/01/2023.
 * Email: muhammed97r@hotmail.com
 * Github: https://github.com/muhammedelsami
 * LinkedIn: https://www.linkedin.com/in/muhammed-elsami/
 */

class Toastoy {
    companion object {

        val ani = AnimateUtils()

        /**
         * Font used when no [ToastoyFont] is passed to a show*Toast call.
         * Set it once (e.g. in your Application class) to change the font of every toast.
         */
        @JvmStatic
        var defaultFont: ToastoyFont = ToastoyFont.CAIRO

        /** With activity */

        @JvmStatic
        @JvmOverloads
        fun showDefaultToast(activity: Activity, message: String, font: ToastoyFont = defaultFont) {
            show(activity, message, font, R.color.default_color, icon = null, animate = null)
        }

        @JvmStatic
        @JvmOverloads
        fun showSuccessToast(activity: Activity, message: String, font: ToastoyFont = defaultFont) {
            show(activity, message, font, R.color.success_color, R.drawable.success, ani::successAnimate)
        }

        @JvmStatic
        @JvmOverloads
        fun showErrorToast(activity: Activity, message: String, font: ToastoyFont = defaultFont) {
            show(activity, message, font, R.color.error_color, R.drawable.error, ani::popUpAnimate)
        }

        @JvmStatic
        @JvmOverloads
        fun showInfoToast(activity: Activity, message: String, font: ToastoyFont = defaultFont) {
            show(activity, message, font, R.color.info_color, R.drawable.info, ani::infoAnimate)
        }

        @JvmStatic
        @JvmOverloads
        fun showWarningToast(activity: Activity, message: String, font: ToastoyFont = defaultFont) {
            show(activity, message, font, R.color.warning_color, R.drawable.warning, ani::warningAnimate)
        }

        /** With context */

        @JvmStatic
        @JvmOverloads
        fun showDefaultToast(context: Context, message: String, font: ToastoyFont = defaultFont) {
            showDefaultToast(context as Activity, message, font)
        }

        @JvmStatic
        @JvmOverloads
        fun showSuccessToast(context: Context, message: String, font: ToastoyFont = defaultFont) {
            showSuccessToast(context as Activity, message, font)
        }

        @JvmStatic
        @JvmOverloads
        fun showErrorToast(context: Context, message: String, font: ToastoyFont = defaultFont) {
            showErrorToast(context as Activity, message, font)
        }

        @JvmStatic
        @JvmOverloads
        fun showInfoToast(context: Context, message: String, font: ToastoyFont = defaultFont) {
            showInfoToast(context as Activity, message, font)
        }

        @JvmStatic
        @JvmOverloads
        fun showWarningToast(context: Context, message: String, font: ToastoyFont = defaultFont) {
            showWarningToast(context as Activity, message, font)
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        private fun show(
            activity: Activity,
            message: String,
            font: ToastoyFont,
            @ColorRes borderColor: Int,
            @DrawableRes icon: Int?,
            animate: ((View) -> Unit)?
        ) {
            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity, borderColor))

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            if (icon == null) {
                toastIcon.visibility = View.GONE
            } else {
                toastIcon.setImageResource(icon)
                animate?.invoke(toastIcon)
            }

            // set the text and font of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message
            textView.typeface = font.typeface(activity)

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

    }
}
