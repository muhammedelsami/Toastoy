package com.muhammed.toastoy

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Build
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.widget.ImageViewCompat

/**
 * Created by Muhammed Elşami on 14/01/2023.
 * Email: muhammed97r@hotmail.com
 * Github: https://github.com/muhammedelsami
 * LinkedIn: https://www.linkedin.com/in/muhammed-elsami/
 */

class Toastoy {
    companion object {

        /**
         * Font used when no [ToastoyFont] is passed to a show*Toast call.
         * Set it once (e.g. in your Application class) to change the font of every toast.
         */
        @JvmStatic
        var defaultFont: ToastoyFont = ToastoyFont.CAIRO

        /** Text size in sp used when no `textSize` is passed to a show*Toast call. */
        @JvmStatic
        var defaultTextSize: Float = 14f

        /** Font weight used when no [ToastoyFontWeight] is passed to a show*Toast call. */
        @JvmStatic
        var defaultFontWeight: ToastoyFontWeight = ToastoyFontWeight.MEDIUM

        /** Alpha of the accent colour behind the icon (0–255). */
        private const val ICON_BACKGROUND_ALPHA = 0x2E

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
            show(context, message, font, textSize, fontWeight, accentColor = null, icon = null)
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
            show(context, message, font, textSize, fontWeight, R.color.toastoy_success, R.drawable.toastoy_ic_success)
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
            show(context, message, font, textSize, fontWeight, R.color.toastoy_error, R.drawable.toastoy_ic_error)
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
            show(context, message, font, textSize, fontWeight, R.color.toastoy_info, R.drawable.toastoy_ic_info)
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
            show(context, message, font, textSize, fontWeight, R.color.toastoy_warning, R.drawable.toastoy_ic_warning)
        }

        /** With activity (kept for source/binary compatibility; an Activity is just a Context) */

        @JvmStatic
        @JvmOverloads
        fun showDefaultToast(
            activity: Activity,
            message: String,
            font: ToastoyFont = defaultFont,
            textSize: Float = defaultTextSize,
            fontWeight: ToastoyFontWeight = defaultFontWeight
        ) {
            showDefaultToast(activity as Context, message, font, textSize, fontWeight)
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
            showSuccessToast(activity as Context, message, font, textSize, fontWeight)
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
            showErrorToast(activity as Context, message, font, textSize, fontWeight)
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
            showInfoToast(activity as Context, message, font, textSize, fontWeight)
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
            showWarningToast(activity as Context, message, font, textSize, fontWeight)
        }

        private fun show(
            context: Context,
            message: String,
            font: ToastoyFont,
            textSize: Float,
            fontWeight: ToastoyFontWeight,
            @ColorRes accentColor: Int?,
            @DrawableRes icon: Int?
        ) {
            val layout = LayoutInflater.from(context).inflate(R.layout.toastoy_toast, null)

            val iconView = layout.findViewById<ImageView>(R.id.toastoy_icon)
            if (icon == null || accentColor == null) {
                iconView.visibility = View.GONE
            } else {
                val accent = ContextCompat.getColor(context, accentColor)
                iconView.setImageResource(icon)
                ImageViewCompat.setImageTintList(iconView, ColorStateList.valueOf(accent))
                iconView.backgroundTintList =
                    ColorStateList.valueOf(ColorUtils.setAlphaComponent(accent, ICON_BACKGROUND_ALPHA))
                iconView.visibility = View.VISIBLE
            }

            val textView = layout.findViewById<TextView>(R.id.toastoy_text)
            textView.text = message
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
            applyFont(textView, font, fontWeight)

            val bottomOffset = context.resources.getDimensionPixelSize(R.dimen.toastoy_bottom_offset)
            @Suppress("DEPRECATION") // custom toast views are still supported for foreground apps
            Toast(context).apply {
                setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, bottomOffset)
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
