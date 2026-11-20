package io.github.agustux.remetro.extensions

import androidx.core.view.WindowInsetsCompat
import io.github.agustux.remetro.util.PreferenceUtil
import io.github.agustux.remetro.util.RetroUtil

fun WindowInsetsCompat?.getBottomInsets(): Int {
    return if (PreferenceUtil.isFullScreenMode) {
        return 0
    } else {
        this?.getInsets(WindowInsetsCompat.Type.systemBars())?.bottom ?: RetroUtil.navigationBarHeight
    }
}
