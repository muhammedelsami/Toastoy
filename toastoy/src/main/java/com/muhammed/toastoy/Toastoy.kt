package com.muhammed.toastoy

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.TypedValue
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

        /** Text size in sp used when no `textSize` is passed to a show*Toast call. */
        @JvmStatic
        var defaultTextSize: Float = 18f

        /** Font weight used when no [ToastoyFontWeight] is passed to a show*Toast call. */
        @JvmStatic
        var defaultFontWeight: ToastoyFontWeight = ToastoyFontWeight.BOLD

        /** With activity */

        @JvmStatic
        @JvmOverloads
        fun showDefaultToast(
            activity: Activity,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            show(activity, message, font, textSize, fontWeight, R.color.default_color, icon = null, animate = null)
        }

        @JvmStatic
        @JvmOverloads
        fun showSuccessToast(
            activity: Activity,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            show(activity, message, font, textSize, fontWeight, R.color.success_color, R.drawable.success, ani::successAnimate)
        }

        @JvmStatic
        @JvmOverloads
        fun showErrorToast(
            activity: Activity,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            show(activity, message, font, textSize, fontWeight, R.color.error_color, R.drawable.error, ani::popUpAnimate)
        }

        @JvmStatic
        @JvmOverloads
        fun showInfoToast(
            activity: Activity,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            show(activity, message, font, textSize, fontWeight, R.color.info_color, R.drawable.info, ani::infoAnimate)
        }

        @JvmStatic
        @JvmOverloads
        fun showWarningToast(
            activity: Activity,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            show(activity, message, font, textSize, fontWeight, R.color.warning_color, R.drawable.warning, ani::warningAnimate)
        }

        /** With context */

        @JvmStatic
        @JvmOverloads
        fun showDefaultToast(
            context: Context,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            showDefaultToast(context as Activity, message, font, textSize, fontWeight)
        }

        @JvmStatic
        @JvmOverloads
        fun showSuccessToast(
            context: Context,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            showSuccessToast(context as Activity, message, font, textSize, fontWeight)
        }

        @JvmStatic
        @JvmOverloads
        fun showErrorToast(
            context: Context,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            showErrorToast(context as Activity, message, font, textSize, fontWeight)
        }

        @JvmStatic
        @JvmOverloads
        fun showInfoToast(
            context: Context,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            showInfoToast(context as Activity, message, font, textSize, fontWeight)
        }

        @JvmStatic
        @JvmOverloads
        fun showWarningToast(
            context: Context,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            showWarningToast(context as Activity, message, font, textSize, fontWeight)
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        private fun show(
            activity: Activity,
            message: String,
            font: ToastoyFont,
            textSize: Float,
            fontWeight: ToastoyFontWeight,
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

            // set the text, size, font and weight of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
            applyFont(textView, font, fontWeight)

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        /**
         * Applies [font] at [weight] through the variable font's `wght` axis.
         * Axes need API 26+; below that the font's default instance is used and
         * heavy weights are emulated with synthetic bold.
         */
        private fun applyFont(textView: TextView, font: ToastoyFont, weight: ToastoyFontWeight) {
            val typeface = font.typeface(textView.context)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                textView.typeface = typeface
                textView.fontVariationSettings = "'wght' ${weight.value}"
            } else {
                val style = if (weight.value >= ToastoyFontWeight.SEMI_BOLD.value) Typeface.BOLD else Typeface.NORMAL
                textView.setTypeface(typeface, style)
            }
        }

    }
}
