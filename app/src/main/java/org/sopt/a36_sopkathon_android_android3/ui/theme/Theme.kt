package org.sopt.a36_sopkathon_android_android3.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LocalHaemuraColors = staticCompositionLocalOf<HaemuraColors> {
    error("No AlarmiColors provided")
}

private val LocalHaemuraTypography = staticCompositionLocalOf<HaemuraTypography> {
    error("No AlarmiTypography provided")
}


object HaeMuraTheme {
    val colors: HaemuraColors
        @Composable
        @ReadOnlyComposable
        get() = LocalHaemuraColors.current

    val typography: HaemuraTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalHaemuraTypography.current
}

// Provider -> Provide
@Composable
fun ProvideAlarmiColorsAndTypography(
    colors: HaemuraColors,
    typography: HaemuraTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalHaemuraColors provides colors,
        LocalHaemuraTypography provides typography,
        content = content
    )
}



@Composable
fun HaeMuraTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.run {
                WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
            }
        }
    }

    ProvideAlarmiColorsAndTypography(
        colors = defaultHaemuraColors,
        typography = defaultHaemuraTypography
    ) {
        MaterialTheme(
            content = content
        )
    }
}
