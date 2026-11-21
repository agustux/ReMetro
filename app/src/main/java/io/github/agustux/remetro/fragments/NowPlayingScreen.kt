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
package io.github.agustux.remetro.fragments

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.github.agustux.remetro.R

enum class NowPlayingScreen constructor(
    @param:StringRes @field:StringRes
    val titleRes: Int,
    @param:DrawableRes @field:DrawableRes val drawableResId: Int,
    val id: Int,
    val defaultCoverTheme: AlbumCoverStyle?
) {
    // Some Now playing themes look better with particular Album cover theme

    Blur(R.string.blur, R.drawable.np_blur, 4, AlbumCoverStyle.Normal),
    Classic(R.string.classic, R.drawable.np_classic, 16, AlbumCoverStyle.Full),
    Color(R.string.color, R.drawable.np_color, 5, AlbumCoverStyle.Normal),
    Material(R.string.material, R.drawable.np_material, 11, AlbumCoverStyle.Normal),
    MD3(R.string.md3, R.drawable.np_normal, 18, AlbumCoverStyle.Normal),
    Normal(R.string.normal, R.drawable.np_normal, 0, AlbumCoverStyle.Normal),
    Peek(R.string.peek, R.drawable.np_peek, 14, AlbumCoverStyle.Normal),
    Plain(R.string.plain, R.drawable.np_plain, 3, AlbumCoverStyle.Normal),
    Simple(R.string.simple, R.drawable.np_simple, 8, AlbumCoverStyle.Normal);

    val supportsAdaptiveColor get() = this == Normal || this == Material
}
