package io.github.agustux.remetro.interfaces

import io.github.agustux.remetro.model.Album
import io.github.agustux.remetro.model.Artist
import io.github.agustux.remetro.model.Genre

interface IHomeClickListener {
    fun onAlbumClick(album: Album)

    fun onArtistClick(artist: Artist)

    fun onGenreClick(genre: Genre)
}