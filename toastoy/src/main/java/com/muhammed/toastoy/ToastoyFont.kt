package com.muhammed.toastoy

import android.content.Context
import android.graphics.Typeface
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat

/**
 * Fonts bundled with Toastoy.
 *
 * All of them are free fonts from Google Fonts (SIL Open Font License) and
 * cover Latin (English, Turkish) and Arabic scripts.
 *
 * Usage:
 * ```
 * Toastoy.showSuccessToast(this, "Done!", ToastoyFont.CAIRO)
 * // or set once for every toast
 * Toastoy.defaultFont = ToastoyFont.ALEXANDRIA
 * ```
 */
enum class ToastoyFont(@FontRes val fontRes: Int) {
    CAIRO(R.font.cairo_bold),
    ALEXANDRIA(R.font.alexandria_bold),
    RUBIK(R.font.rubik_bold),
    READEX_PRO(R.font.readex_pro_bold),
    CHANGA(R.font.changa_bold),
    VAZIRMATN(R.font.vazirmatn_bold),
    EL_MESSIRI(R.font.el_messiri_bold),
    NOTO_KUFI_ARABIC(R.font.noto_kufi_arabic_bold);

    /** Resolves the bundled font, falling back to the system bold font if it cannot be loaded. */
    fun typeface(context: Context): Typeface =
        ResourcesCompat.getFont(context, fontRes) ?: Typeface.DEFAULT_BOLD
}
