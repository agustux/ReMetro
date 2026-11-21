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
import io.github.agustux.remetro.EXTRA_PLAYLIST_ID
import io.github.agustux.remetro.R
import io.github.agustux.remetro.databinding.DialogPlaylistBinding
import io.github.agustux.remetro.db.PlaylistEntity
import io.github.agustux.remetro.extensions.accentColor
import io.github.agustux.remetro.extensions.colorButtons
import io.github.agustux.remetro.extensions.extraNotNull
import io.github.agustux.remetro.extensions.materialDialog
import io.github.agustux.remetro.extensions.requireNameOnPositive
import io.github.agustux.remetro.fragments.LibraryViewModel
import io.github.agustux.remetro.fragments.ReloadType
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class RenamePlaylistDialog : DialogFragment() {

    private val libraryViewModel by activityViewModel<LibraryViewModel>()
    private var _binding: DialogPlaylistBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun create(playlistEntity: PlaylistEntity): RenamePlaylistDialog {
            return RenamePlaylistDialog().apply {
                arguments = bundleOf(
                    EXTRA_PLAYLIST_ID to playlistEntity
                )
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val playlistEntity = extraNotNull<PlaylistEntity>(EXTRA_PLAYLIST_ID).value
        _binding = DialogPlaylistBinding.inflate(layoutInflater)
        binding.actionNewPlaylistContainer.accentColor()
        binding.actionNewPlaylist.setText(playlistEntity.playlistName)
        binding.actionNewPlaylist.doAfterTextChanged { binding.actionNewPlaylistContainer.error = null }
        return materialDialog(R.string.rename_playlist_title)
            .setView(binding.root)
            .setNegativeButton(android.R.string.cancel, null)
            // Click handled in onStart so an empty name keeps the dialog open
            .setPositiveButton(R.string.action_rename, null)
            .create()
            .colorButtons()
    }

    override fun onStart() {
        super.onStart()
        requireNameOnPositive(binding.actionNewPlaylistContainer) { name ->
            val playlistEntity = extraNotNull<PlaylistEntity>(EXTRA_PLAYLIST_ID).value
            libraryViewModel.renameRoomPlaylist(playlistEntity.playListId, name)
            libraryViewModel.forceReload(ReloadType.Playlists)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
