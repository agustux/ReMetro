package io.github.agustux.remetro.interfaces

import android.view.View
import io.github.agustux.remetro.model.Genre

interface IGenreClickListener {
    fun onClickGenre(genre: Genre, view: View)
}