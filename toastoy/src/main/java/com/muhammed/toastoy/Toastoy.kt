package com.muhammed.toastoy

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

        /** With activity */

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showDefaultToast(activity: Activity, message: String) {

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.default_color))
            //bor.background = getDrawable(activity,R.drawable.ic_arrow_forward)

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.visibility = View.GONE
            //toastIcon.setImageResource(R.drawable.ic_default)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showSuccessToast(activity: Activity, message: String) {

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.success_color))
            //bor.background = getDrawable(activity,R.drawable.ic_arrow_forward)

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.setImageResource(R.drawable.success)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showErrorToast(activity: Activity, message: String) {

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            var border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.error_color))

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.setImageResource(R.drawable.error)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showInfoToast(activity: Activity, message: String) {

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.info_color))
            //bor.background = getDrawable(activity,R.drawable.ic_arrow_forward)

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.setImageResource(R.drawable.info)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showWarningToast(activity: Activity, message: String) {

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.warning_color))
            //bor.background = getDrawable(activity,R.drawable.ic_arrow_forward)

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.setImageResource(R.drawable.warning)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        /** With context */

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showDefaultToast(context: Context, message: String) {

            val activity = context as Activity

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.default_color))
            //bor.background = getDrawable(activity,R.drawable.ic_arrow_forward)

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.visibility = View.GONE
            //toastIcon.setImageResource(R.drawable.ic_default)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showSuccessToast(context: Context, message: String) {

            val activity = context as Activity

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.success_color))
            //bor.background = getDrawable(activity,R.drawable.ic_arrow_forward)

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.setImageResource(R.drawable.success)

            ani.successAnimate(toastIcon)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables", "Recycle")
        fun showErrorToast(context: Context, message: String) {

            val activity = context as Activity

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            var border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.error_color))

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.setImageResource(R.drawable.error)

            ani.popUpAnimate(toastIcon)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showInfoToast(context: Context, message: String) {

            val activity = context as Activity

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.info_color))
            //bor.background = getDrawable(activity,R.drawable.ic_arrow_forward)

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.setImageResource(R.drawable.info)

            ani.infoAnimate(toastIcon)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

            // use the application extension function
            Toast(activity).apply {
                setGravity(Gravity.BOTTOM, 0, 40)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }

        @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables")
        fun showWarningToast(context: Context, message: String) {

            val activity = context as Activity

            val layout = activity.layoutInflater.inflate(
                R.layout.custom_toast,
                activity.findViewById(R.id.toast_container)
            )

            val border = layout.findViewById<View>(R.id.button_accent_border)
            border.setBackgroundColor(getColor(activity,R.color.warning_color))
            //bor.background = getDrawable(activity,R.drawable.ic_arrow_forward)

            val toastIcon = layout.findViewById<ImageView>(R.id.toast_icon)
            toastIcon.setImageResource(R.drawable.warning)

            ani.warningAnimate(toastIcon)

            // set the text of the TextView of the message
            val textView = layout.findViewById<TextView>(R.id.toast_text)
            textView.text = message

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