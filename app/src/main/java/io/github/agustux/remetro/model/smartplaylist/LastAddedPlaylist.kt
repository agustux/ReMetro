package io.github.agustux.remetro.model.smartplaylist

import io.github.agustux.remetro.App
import io.github.agustux.remetro.R
import io.github.agustux.remetro.model.Song
import kotlinx.parcelize.Parcelize

@Parcelize
class LastAddedPlaylist : AbsSmartPlaylist(
    name = App.getContext().getString(R.string.last_added),
    iconRes = R.drawable.ic_library_add
) {
    override fun songs(): List<Song> {
        return lastAddedRepository.recentSongs()
    }
}