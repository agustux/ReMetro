package io.github.agustux.remetro.util.theme

import android.content.Context
import android.graphics.Color
import androidx.annotation.StyleRes
import io.github.agustux.remetro.R
import io.github.agustux.remetro.appthemehelper.ACCENT_COLORS_SUB
import io.github.agustux.remetro.appthemehelper.ThemeStore

/**
 * Theme attributes can't take arbitrary colors at runtime, so `colorPrimary` follows the
 * accent through one overlay per Catppuccin accent (styles_accent.xml). Preset accents match
 * exactly; custom accents use the closest preset.
 */
object AccentTheme {
    private val colors = ACCENT_COLORS_SUB.flatMap { it.asIterable() }

    // Same order as ACCENT_COLORS_SUB: per hue, Latte, Frappé, Macchiato, Mocha
    private val overlays = intArrayOf(
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Rosewater,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Rosewater,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Rosewater,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Rosewater,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Flamingo,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Flamingo,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Flamingo,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Flamingo,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Pink,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Pink,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Pink,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Pink,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Mauve,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Mauve,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Mauve,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Mauve,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Red,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Red,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Red,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Red,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Maroon,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Maroon,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Maroon,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Maroon,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Peach,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Peach,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Peach,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Peach,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Yellow,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Yellow,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Yellow,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Yellow,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Green,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Green,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Green,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Green,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Teal,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Teal,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Teal,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Teal,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Sky,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Sky,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Sky,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Sky,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Sapphire,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Sapphire,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Sapphire,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Sapphire,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Blue,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Blue,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Blue,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Blue,
        R.style.ThemeOverlay_ReMetro_Accent_Latte_Lavender,
        R.style.ThemeOverlay_ReMetro_Accent_Frappe_Lavender,
        R.style.ThemeOverlay_ReMetro_Accent_Macchiato_Lavender,
        R.style.ThemeOverlay_ReMetro_Accent_Mocha_Lavender,
    )

    @StyleRes
    fun overlayFor(context: Context): Int {
        val accent = ThemeStore.accentColor(context)
        return overlays[colors.indices.minBy { distance(accent, colors[it]) }]
    }

    private fun distance(a: Int, b: Int): Int {
        val r = Color.red(a) - Color.red(b)
        val g = Color.green(a) - Color.green(b)
        val bl = Color.blue(a) - Color.blue(b)
        return r * r + g * g + bl * bl
    }
}
