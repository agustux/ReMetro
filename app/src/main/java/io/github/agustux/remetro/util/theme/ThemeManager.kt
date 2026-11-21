package io.github.agustux.remetro.util.theme

import android.content.Context
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatDelegate
import io.github.agustux.remetro.R
import io.github.agustux.remetro.appthemehelper.util.VersionUtils
import io.github.agustux.remetro.extensions.generalThemeValue
import io.github.agustux.remetro.util.PreferenceUtil
import io.github.agustux.remetro.util.theme.ThemeMode.*

@StyleRes
fun Context.getThemeResValue(): Int =
    if (PreferenceUtil.materialYou) {
        if (generalThemeValue == BLACK) R.style.Theme_ReMetro_MD3_Black
        else R.style.Theme_ReMetro_MD3
    } else {
        when (generalThemeValue) {
            LIGHT -> R.style.Theme_ReMetro_Light
            DARK -> R.style.Theme_ReMetro_Base
            BLACK -> R.style.Theme_ReMetro_Black
            AUTO -> R.style.Theme_ReMetro_FollowSystem
        }
    }

/** Keeps `-night` resources in sync with the chosen theme instead of the system's. */
fun getNightMode(): Int = when (PreferenceUtil.getGeneralThemeValue(false)) {
    LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
    DARK, BLACK -> AppCompatDelegate.MODE_NIGHT_YES
    AUTO -> if (VersionUtils.hasQ()) AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    else AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
}