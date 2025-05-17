package org.sopt.a36_sopkathon_android_android3.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val yellow = Color(0xFFFFFDE2)
val primary = Color(0xFFFF6011)
val orange = Color(0xFFFF8B1E)

val bg = Color(0xFFFFFBF2)
val card = Color (0xFFFFFEFD)

val light = Color(0xFFD3A983)
val dark = Color(0xFF452214)

val white = Color(0xFFFFFFFF)
val black = Color(0xFF2B2B2B)

@Immutable
data class HaemuraColors(
    val yellow: Color,
    val primary: Color,
    val orange: Color,

    val bg: Color,
    val card: Color,

    val light: Color,
    val dark: Color,

    val white: Color,
    val black: Color
)

val defaultHaemuraColors = HaemuraColors(
    yellow = yellow,
    primary = primary,
    orange = orange,

    bg = bg,
    card = card,

    light = light,
    dark = dark,

    white = white,
    black = black
)
