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
package io.github.agustux.remetro.extensions

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import io.github.agustux.remetro.R
import com.afollestad.materialdialogs.MaterialDialog
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Fragment.materialDialog(title: Int): MaterialAlertDialogBuilder {
    return MaterialAlertDialogBuilder(requireContext(), R.style.MaterialAlertDialogTheme)
        .setTitle(title)
}

fun Fragment.materialDialog(title: CharSequence): MaterialAlertDialogBuilder {
    return MaterialAlertDialogBuilder(requireContext(), R.style.MaterialAlertDialogTheme)
        .setTitle(title)
}

fun AlertDialog.colorButtons(): AlertDialog {
    setOnShowListener {
        getButton(AlertDialog.BUTTON_POSITIVE).accentTextColor()
        getButton(AlertDialog.BUTTON_NEGATIVE).accentTextColor()
        getButton(AlertDialog.BUTTON_NEUTRAL).accentTextColor()
    }
    return this
}

/**
 * Call from onStart: the positive button keeps the dialog open and flags [container] while
 * its text is empty, otherwise passes the text to [onName] and dismisses.
 */
fun DialogFragment.requireNameOnPositive(container: TextInputLayout, onName: (String) -> Unit) {
    (dialog as? AlertDialog)?.getButton(AlertDialog.BUTTON_POSITIVE)?.setOnClickListener {
        val name = container.editText?.text?.toString().orEmpty()
        if (name.isEmpty()) {
            container.error = getString(R.string.playlist_name_cannot_be_empty)
        } else {
            onName(name)
            dismiss()
        }
    }
}

fun Fragment.materialDialog(): MaterialDialog {
    return MaterialDialog(requireContext())
        .cornerRadius(res = R.dimen.m3_dialog_corner_size)
}
