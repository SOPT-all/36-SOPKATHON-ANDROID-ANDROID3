package org.sopt.a36_sopkathon_android_android3.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.a36_sopkathon_android_android3.R

val HaemuraFont = FontFamily(Font(R.font.moneygraphy_rounded))
// Set of Material typography styles to start with

@Immutable
data class HaemuraTypography(
    val head_spc_24 : TextStyle,
    val head_spc_16 : TextStyle,
    val button_spc_14 : TextStyle,
    val body_spc_14 : TextStyle,
    val body_spc_12 : TextStyle,

    val head_18_SB : TextStyle,
    val head_16SB : TextStyle,
    val body_14R : TextStyle,
    val body_12SB : TextStyle,
    val body_12R : TextStyle,

    val caption_12R : TextStyle,
    val caption_10M : TextStyle
)

private fun HaemuraTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)

    val defaultHaemuraTypography = HaemuraTypography(
        head_spc_24 = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 24.sp,
            lineHeight = 1.50.em,
            letterSpacing = (0).em
        ),
        head_spc_16 = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 16.sp,
            lineHeight = 1.50.em,
            letterSpacing = (0).em
        ),

        button_spc_14 =HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 14.sp,
            lineHeight = 1.50.em,
            letterSpacing = (0).em
        ),

        body_spc_14 = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 14.sp,
            lineHeight = 1.60.em,
            letterSpacing = (0).em
        ),

        body_spc_12 = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 12.sp,
            lineHeight = 1.50.em,
            letterSpacing = (0).em
        ),

        head_18_SB = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 18.sp,
            lineHeight = 1.50.em,
            letterSpacing = (0).em
        ),

        head_16SB = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 16.sp,
            lineHeight = 1.50.em,
            letterSpacing = (0).em
        ),

        body_14R =HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 14.sp,
            lineHeight = 1.60.em,
            letterSpacing = (0).em
        ),

        body_12SB = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 12.sp,
            lineHeight = 1.00.em,
            letterSpacing = (0).em
        ),

        body_12R = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 12.sp,
            lineHeight = 1.00.em,
            letterSpacing = (0).em
        ),

        caption_12R = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 14.sp,
            lineHeight = 1.40.em,
            letterSpacing = (0).em
        ),

        caption_10M = HaemuraTextStyle(
            fontFamily = HaemuraFont,
            fontSize = 10.sp,
            lineHeight = 1.00.em,
            letterSpacing = (0).em
        ),


        )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
