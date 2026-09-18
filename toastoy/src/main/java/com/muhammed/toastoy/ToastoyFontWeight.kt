package com.muhammed.toastoy

/**
 * Font weight of the toast message, mapped to the `wght` axis of the bundled
 * variable fonts (100 = thinnest, 900 = heaviest).
 *
 * Each font supports a different range (for example El Messiri 400–700,
 * Cairo 200–1000); values outside a font's range are clamped to its nearest edge.
 *
 * Variable font axes need API 26+. On API 24–25 the font's default instance is used
 * and weights of [SEMI_BOLD] and above fall back to synthetic bold.
 */
enum class ToastoyFontWeight(val value: Int) {
    THIN(100),
    EXTRA_LIGHT(200),
    LIGHT(300),
    NORMAL(400),
    MEDIUM(500),
    SEMI_BOLD(600),
    BOLD(700),
    EXTRA_BOLD(800),
    BLACK(900);
}
