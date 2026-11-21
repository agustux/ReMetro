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
package io.github.agustux.remetro.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.DialogFragment
import io.github.agustux.remetro.EXTRA_SONG
import io.github.agustux.remetro.R
import io.github.agustux.remetro.databinding.DialogPlaylistBinding
import io.github.agustux.remetro.extensions.accentColor
import io.github.agustux.remetro.extensions.colorButtons
import io.github.agustux.remetro.extensions.extra
import io.github.agustux.remetro.extensions.materialDialog
import io.github.agustux.remetro.extensions.requireNameOnPositive
import io.github.agustux.remetro.fragments.LibraryViewModel
import io.github.agustux.remetro.model.Song
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class CreatePlaylistDialog : DialogFragment() {
    private var _binding: DialogPlaylistBinding? = null
    private val binding get() = _binding!!
    private val libraryViewModel by activityViewModel<LibraryViewModel>()

    companion object {
        fun create(song: Song): CreatePlaylistDialog {
            val list = mutableListOf<Song>()
            list.add(song)
            return create(list)
        }

        fun create(songs: List<Song>): CreatePlaylistDialog {
            return CreatePlaylistDialog().apply {
                arguments = bundleOf(EXTRA_SONG to songs)
            }
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogPlaylistBinding.inflate(layoutInflater)

        binding.actionNewPlaylistContainer.accentColor()
        binding.actionNewPlaylist.doAfterTextChanged { binding.actionNewPlaylistContainer.error = null }
        return materialDialog(R.string.new_playlist_title)
            .setView(binding.root)
            // Click handled in onStart so an empty name keeps the dialog open
            .setPositiveButton(R.string.create_action, null)
            .setNegativeButton(R.string.action_cancel, null)
            .create()
            .colorButtons()
    }

    override fun onStart() {
        super.onStart()
        requireNameOnPositive(binding.actionNewPlaylistContainer) { playlistName ->
            val songs: List<Song> = extra<List<Song>>(EXTRA_SONG).value ?: emptyList()
            libraryViewModel.addToPlaylist(requireContext(), playlistName, songs)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
