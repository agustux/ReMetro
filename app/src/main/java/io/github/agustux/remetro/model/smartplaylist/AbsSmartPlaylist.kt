package io.github.agustux.remetro.model.smartplaylist

import androidx.annotation.DrawableRes
import io.github.agustux.remetro.R
import io.github.agustux.remetro.model.AbsCustomPlaylist

abstract class AbsSmartPlaylist(
    name: String,
    @DrawableRes val iconRes: Int = R.drawable.ic_queue_music
) : AbsCustomPlaylist(
    id = PlaylistIdGenerator(name, iconRes),
    name = name
)