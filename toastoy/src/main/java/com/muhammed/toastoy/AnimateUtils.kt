package com.muhammed.toastoy

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator

class AnimateUtils {

    fun successAnimate(view: View) {
        val x = ObjectAnimator.ofFloat(view,"rotation", 0.0f, 360f).apply {
            duration = 800
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            interpolator = AccelerateInterpolator(1f)
        }.start()
    }

    fun popUpAnimate(toastIcon: View) {

        val x = ObjectAnimator.ofFloat(toastIcon,"scaleX", 1f, 1.2f).apply {
            duration = 500
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        val y = ObjectAnimator.ofFloat(toastIcon,"scaleY", 1f, 1.2f).apply {
            duration = 500
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        AnimatorSet().apply {
            playTogether(x,y)
        }.start()
    }

    fun warningAnimate(toastIcon: View) {

        val x = ObjectAnimator.ofFloat(toastIcon,"translationX", 0.0f, 5.0f).apply {
            duration = 100
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

    }

    fun infoAnimate(toastIcon: View) {

        val x = ObjectAnimator.ofFloat(toastIcon,"alpha", 0.0f, 1.0f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

    }

}