package com.muhammed.toastoy

import android.content.Context
import android.graphics.Typeface
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat

/**
 * Fonts bundled with Toastoy.
 *
 * All of them are free variable fonts from Google Fonts (SIL Open Font License) and
 * cover Latin (English, Turkish) and Arabic scripts. Weight is chosen at runtime
 * through [ToastoyFontWeight].
 *
 * Usage:
 * ```
 * Toastoy.showSuccessToast(this, "Done!", ToastoyFont.CAIRO)
 * // or set once for every toast
 * Toastoy.defaultFont = ToastoyFont.ALEXANDRIA
 * ```
 */
enum class ToastoyFont(@FontRes val fontRes: Int) {
    CAIRO(R.font.cairo),
    ALEXANDRIA(R.font.alexandria),
    RUBIK(R.font.rubik),
    READEX_PRO(R.font.readex_pro),
    CHANGA(R.font.changa),
    VAZIRMATN(R.font.vazirmatn),
    EL_MESSIRI(R.font.el_messiri),
    NOTO_KUFI_ARABIC(R.font.noto_kufi_arabic);

    /** Resolves the bundled font, falling back to the system font if it cannot be loaded. */
    fun typeface(context: Context): Typeface =
        ResourcesCompat.getFont(context, fontRes) ?: Typeface.DEFAULT
}
