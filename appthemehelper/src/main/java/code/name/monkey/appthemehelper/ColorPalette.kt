package code.name.monkey.appthemehelper

/**
 * Designed and developed by Aidan Follestad (@afollestad)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.graphics.Color.parseColor

val PRIMARY_COLORS = intArrayOf(
        parseColor("#F44336"), parseColor("#E91E63"), parseColor("#9C27B0"),
        parseColor("#673AB7"), parseColor("#3F51B5"), parseColor("#2196F3"),
        parseColor("#03A9F4"), parseColor("#00BCD4"), parseColor("#009688"),
        parseColor("#4CAF50"), parseColor("#8BC34A"), parseColor("#CDDC39"),
        parseColor("#FFEB3B"), parseColor("#FFC107"), parseColor("#FF9800"),
        parseColor("#FF5722"), parseColor("#795548"), parseColor("#9E9E9E"),
        parseColor("#607D8B")
)

val PRIMARY_COLORS_SUB = arrayOf(
        intArrayOf(
                parseColor("#FFEBEE"), parseColor("#FFCDD2"), parseColor("#EF9A9A"),
                parseColor("#E57373"), parseColor("#EF5350"), parseColor("#F44336"),
                parseColor("#E53935"), parseColor("#D32F2F"), parseColor("#C62828"),
                parseColor("#B71C1C")
        ), intArrayOf(
        parseColor("#FCE4EC"), parseColor("#F8BBD0"), parseColor("#F48FB1"),
        parseColor("#F06292"), parseColor("#EC407A"), parseColor("#E91E63"),
        parseColor("#D81B60"), parseColor("#C2185B"), parseColor("#AD1457"),
        parseColor("#880E4F")
), intArrayOf(
        parseColor("#F3E5F5"), parseColor("#E1BEE7"), parseColor("#CE93D8"),
        parseColor("#BA68C8"), parseColor("#AB47BC"), parseColor("#9C27B0"),
        parseColor("#8E24AA"), parseColor("#7B1FA2"), parseColor("#6A1B9A"),
        parseColor("#4A148C")
), intArrayOf(
        parseColor("#EDE7F6"), parseColor("#D1C4E9"), parseColor("#B39DDB"),
        parseColor("#9575CD"), parseColor("#7E57C2"), parseColor("#673AB7"),
        parseColor("#5E35B1"), parseColor("#512DA8"), parseColor("#4527A0"),
        parseColor("#311B92")
), intArrayOf(
        parseColor("#E8EAF6"), parseColor("#C5CAE9"), parseColor("#9FA8DA"),
        parseColor("#7986CB"), parseColor("#5C6BC0"), parseColor("#3F51B5"),
        parseColor("#3949AB"), parseColor("#303F9F"), parseColor("#283593"),
        parseColor("#1A237E")
), intArrayOf(
        parseColor("#E3F2FD"), parseColor("#BBDEFB"), parseColor("#90CAF9"),
        parseColor("#64B5F6"), parseColor("#42A5F5"), parseColor("#2196F3"),
        parseColor("#1E88E5"), parseColor("#1976D2"), parseColor("#1565C0"),
        parseColor("#0D47A1")
), intArrayOf(
        parseColor("#E1F5FE"), parseColor("#B3E5FC"), parseColor("#81D4FA"),
        parseColor("#4FC3F7"), parseColor("#29B6F6"), parseColor("#03A9F4"),
        parseColor("#039BE5"), parseColor("#0288D1"), parseColor("#0277BD"),
        parseColor("#01579B")
), intArrayOf(
        parseColor("#E0F7FA"), parseColor("#B2EBF2"), parseColor("#80DEEA"),
        parseColor("#4DD0E1"), parseColor("#26C6DA"), parseColor("#00BCD4"),
        parseColor("#00ACC1"), parseColor("#0097A7"), parseColor("#00838F"),
        parseColor("#006064")
), intArrayOf(
        parseColor("#E0F2F1"), parseColor("#B2DFDB"), parseColor("#80CBC4"),
        parseColor("#4DB6AC"), parseColor("#26A69A"), parseColor("#009688"),
        parseColor("#00897B"), parseColor("#00796B"), parseColor("#00695C"),
        parseColor("#004D40")
), intArrayOf(
        parseColor("#E8F5E9"), parseColor("#C8E6C9"), parseColor("#A5D6A7"),
        parseColor("#81C784"), parseColor("#66BB6A"), parseColor("#4CAF50"),
        parseColor("#43A047"), parseColor("#388E3C"), parseColor("#2E7D32"),
        parseColor("#1B5E20")
), intArrayOf(
        parseColor("#F1F8E9"), parseColor("#DCEDC8"), parseColor("#C5E1A5"),
        parseColor("#AED581"), parseColor("#9CCC65"), parseColor("#8BC34A"),
        parseColor("#7CB342"), parseColor("#689F38"), parseColor("#558B2F"),
        parseColor("#33691E")
), intArrayOf(
        parseColor("#F9FBE7"), parseColor("#F0F4C3"), parseColor("#E6EE9C"),
        parseColor("#DCE775"), parseColor("#D4E157"), parseColor("#CDDC39"),
        parseColor("#C0CA33"), parseColor("#AFB42B"), parseColor("#9E9D24"),
        parseColor("#827717")
), intArrayOf(
        parseColor("#FFFDE7"), parseColor("#FFF9C4"), parseColor("#FFF59D"),
        parseColor("#FFF176"), parseColor("#FFEE58"), parseColor("#FFEB3B"),
        parseColor("#FDD835"), parseColor("#FBC02D"), parseColor("#F9A825"),
        parseColor("#F57F17")
), intArrayOf(
        parseColor("#FFF8E1"), parseColor("#FFECB3"), parseColor("#FFE082"),
        parseColor("#FFD54F"), parseColor("#FFCA28"), parseColor("#FFC107"),
        parseColor("#FFB300"), parseColor("#FFA000"), parseColor("#FF8F00"),
        parseColor("#FF6F00")
), intArrayOf(
        parseColor("#FFF3E0"), parseColor("#FFE0B2"), parseColor("#FFCC80"),
        parseColor("#FFB74D"), parseColor("#FFA726"), parseColor("#FF9800"),
        parseColor("#FB8C00"), parseColor("#F57C00"), parseColor("#EF6C00"),
        parseColor("#E65100")
), intArrayOf(
        parseColor("#FBE9E7"), parseColor("#FFCCBC"), parseColor("#FFAB91"),
        parseColor("#FF8A65"), parseColor("#FF7043"), parseColor("#FF5722"),
        parseColor("#F4511E"), parseColor("#E64A19"), parseColor("#D84315"),
        parseColor("#BF360C")
), intArrayOf(
        parseColor("#EFEBE9"), parseColor("#D7CCC8"), parseColor("#BCAAA4"),
        parseColor("#A1887F"), parseColor("#8D6E63"), parseColor("#795548"),
        parseColor("#6D4C41"), parseColor("#5D4037"), parseColor("#4E342E"),
        parseColor("#3E2723")
), intArrayOf(
        parseColor("#FAFAFA"), parseColor("#F5F5F5"), parseColor("#EEEEEE"),
        parseColor("#E0E0E0"), parseColor("#BDBDBD"), parseColor("#9E9E9E"),
        parseColor("#757575"), parseColor("#616161"), parseColor("#424242"),
        parseColor("#212121")
), intArrayOf(
        parseColor("#ECEFF1"), parseColor("#CFD8DC"), parseColor("#B0BEC5"),
        parseColor("#90A4AE"), parseColor("#78909C"), parseColor("#607D8B"),
        parseColor("#546E7A"), parseColor("#455A64"), parseColor("#37474F"),
        parseColor("#263238")
)
)

// Catppuccin accents: Mocha main, sub-colors are Latte, Frappé, Macchiato, Mocha
val ACCENT_COLORS = intArrayOf(
        parseColor("#F5E0DC"),
        parseColor("#F2CDCD"),
        parseColor("#F5C2E7"),
        parseColor("#CBA6F7"),
        parseColor("#F38BA8"),
        parseColor("#EBA0AC"),
        parseColor("#FAB387"),
        parseColor("#F9E2AF"),
        parseColor("#A6E3A1"),
        parseColor("#94E2D5"),
        parseColor("#89DCEB"),
        parseColor("#74C7EC"),
        parseColor("#89B4FA"),
        parseColor("#B4BEFE")
)

val ACCENT_COLORS_SUB = arrayOf(
        intArrayOf(
            parseColor("#DC8A78"), parseColor("#F2D5CF"), parseColor("#F4DBD6"), parseColor("#F5E0DC")
        ),
        intArrayOf(
            parseColor("#DD7878"), parseColor("#EEBEBE"), parseColor("#F0C6C6"), parseColor("#F2CDCD")
        ),
        intArrayOf(
            parseColor("#EA76CB"), parseColor("#F4B8E4"), parseColor("#F5BDE6"), parseColor("#F5C2E7")
        ),
        intArrayOf(
            parseColor("#8839EF"), parseColor("#CA9EE6"), parseColor("#C6A0F6"), parseColor("#CBA6F7")
        ),
        intArrayOf(
            parseColor("#D20F39"), parseColor("#E78284"), parseColor("#ED8796"), parseColor("#F38BA8")
        ),
        intArrayOf(
            parseColor("#E64553"), parseColor("#EA999C"), parseColor("#EE99A0"), parseColor("#EBA0AC")
        ),
        intArrayOf(
            parseColor("#FE640B"), parseColor("#EF9F76"), parseColor("#F5A97F"), parseColor("#FAB387")
        ),
        intArrayOf(
            parseColor("#DF8E1D"), parseColor("#E5C890"), parseColor("#EED49F"), parseColor("#F9E2AF")
        ),
        intArrayOf(
            parseColor("#40A02B"), parseColor("#A6D189"), parseColor("#A6DA95"), parseColor("#A6E3A1")
        ),
        intArrayOf(
            parseColor("#179299"), parseColor("#81C8BE"), parseColor("#8BD5CA"), parseColor("#94E2D5")
        ),
        intArrayOf(
            parseColor("#04A5E5"), parseColor("#99D1DB"), parseColor("#91D7E3"), parseColor("#89DCEB")
        ),
        intArrayOf(
            parseColor("#209FB5"), parseColor("#85C1DC"), parseColor("#7DC4E4"), parseColor("#74C7EC")
        ),
        intArrayOf(
            parseColor("#1E66F5"), parseColor("#8CAAEE"), parseColor("#8AADF4"), parseColor("#89B4FA")
        ),
        intArrayOf(
            parseColor("#7287FD"), parseColor("#BABBF1"), parseColor("#B7BDF8"), parseColor("#B4BEFE")
        )
)
