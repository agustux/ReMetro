package io.github.agustux.remetro.interfaces

import android.view.View
import io.github.agustux.remetro.db.PlaylistWithSongs

interface IPlaylistClickListener {
    fun onPlaylistClick(playlistWithSongs: PlaylistWithSongs, view: View)
}