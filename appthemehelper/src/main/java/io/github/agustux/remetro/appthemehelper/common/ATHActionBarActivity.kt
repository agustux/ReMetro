package io.github.agustux.remetro.appthemehelper.common

import androidx.appcompat.widget.Toolbar

import io.github.agustux.remetro.appthemehelper.util.ToolbarContentTintHelper

class ATHActionBarActivity : ATHToolbarActivity() {

    override fun getATHToolbar(): Toolbar? {
        return ToolbarContentTintHelper.getSupportActionBarView(supportActionBar)
    }
}
