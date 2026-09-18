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
    CAIRO(R.font.toastoy_cairo),
    ALEXANDRIA(R.font.toastoy_alexandria),
    RUBIK(R.font.toastoy_rubik),
    READEX_PRO(R.font.toastoy_readex_pro),
    CHANGA(R.font.toastoy_changa),
    VAZIRMATN(R.font.toastoy_vazirmatn),
    EL_MESSIRI(R.font.toastoy_el_messiri),
    NOTO_KUFI_ARABIC(R.font.toastoy_noto_kufi_arabic);

    /** Resolves the bundled font, falling back to the system font if it cannot be loaded. */
    fun typeface(context: Context): Typeface =
        ResourcesCompat.getFont(context, fontRes) ?: Typeface.DEFAULT
}
