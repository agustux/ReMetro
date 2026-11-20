package io.github.agustux.remetro.model.smartplaylist

import io.github.agustux.remetro.App
import io.github.agustux.remetro.R
import io.github.agustux.remetro.model.Song
import kotlinx.parcelize.Parcelize

@Parcelize
class ShuffleAllPlaylist : AbsSmartPlaylist(
    name = App.getContext().getString(R.string.action_shuffle_all),
    iconRes = R.drawable.ic_shuffle
) {
    override fun songs(): List<Song> {
        return songRepository.songs()
    }
}