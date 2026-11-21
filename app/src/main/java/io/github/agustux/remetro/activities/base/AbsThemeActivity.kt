/*
 * Copyright (c) 2020 Hemanth Savarla.
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 */
package io.github.agustux.remetro.activities.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode
import io.github.agustux.remetro.appthemehelper.common.ATHToolbarActivity
import io.github.agustux.remetro.appthemehelper.util.VersionUtils
import io.github.agustux.remetro.R
import io.github.agustux.remetro.extensions.exitFullscreen
import io.github.agustux.remetro.extensions.hideStatusBar
import io.github.agustux.remetro.extensions.maybeSetScreenOn
import io.github.agustux.remetro.extensions.maybeShowWhenLocked
import io.github.agustux.remetro.extensions.setEdgeToEdgeOrImmersive
import io.github.agustux.remetro.extensions.setImmersiveFullscreen
import io.github.agustux.remetro.extensions.setLightNavigationBarAuto
import io.github.agustux.remetro.extensions.setLightStatusBarAuto
import io.github.agustux.remetro.extensions.surfaceColor
import io.github.agustux.remetro.util.PreferenceUtil
import io.github.agustux.remetro.util.theme.AccentTheme
import io.github.agustux.remetro.util.theme.getNightMode
import io.github.agustux.remetro.util.theme.getThemeResValue

abstract class AbsThemeActivity : ATHToolbarActivity(), Runnable {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        updateTheme()
        hideStatusBar()
        super.onCreate(savedInstanceState)
        setEdgeToEdgeOrImmersive()
        maybeSetScreenOn()
        maybeShowWhenLocked()
        setLightNavigationBarAuto()
        setLightStatusBarAuto(surfaceColor())
        if (VersionUtils.hasQ()) {
            window.decorView.isForceDarkAllowed = false
        }
    }

    private fun updateTheme() {
        setTheme(getThemeResValue())
        setDefaultNightMode(getNightMode())

        if (PreferenceUtil.isCustomFont) {
            setTheme(R.style.FontThemeOverlay)
        }

        // Material You supplies its own primary; otherwise make colorPrimary follow the accent
        if (!PreferenceUtil.materialYou) {
            theme.applyStyle(AccentTheme.overlayFor(this), true)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideStatusBar()
            handler.removeCallbacks(this)
            handler.postDelayed(this, 300)
        } else {
            handler.removeCallbacks(this)
        }
    }

    override fun run() {
        setImmersiveFullscreen()
    }

    override fun onStop() {
        handler.removeCallbacks(this)
        super.onStop()
    }

    public override fun onDestroy() {
        super.onDestroy()
        exitFullscreen()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            handler.removeCallbacks(this)
            handler.postDelayed(this, 500)
        }
        return super.onKeyDown(keyCode, event)
    }
}
