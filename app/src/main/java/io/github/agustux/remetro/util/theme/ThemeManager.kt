package io.github.agustux.remetro.util.theme

import android.content.Context
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatDelegate
import io.github.agustux.remetro.R
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

fun Context.getNightMode(): Int = when (generalThemeValue) {
    LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
    DARK -> AppCompatDelegate.MODE_NIGHT_YES
    else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
}