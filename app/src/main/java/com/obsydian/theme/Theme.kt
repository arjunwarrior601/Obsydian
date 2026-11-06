package com.obsydian.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val ObsydianColorScheme = darkColorScheme(
    primary = ElectricBluePrimary,
    onPrimary = ObsidianBlack,
    primaryContainer = ElectricBlueDark,
    onPrimaryContainer = TitaniumWhite,
    secondary = ElectricBlueSecondary,
    onSecondary = ObsidianBlack,
    secondaryContainer = TitaniumMedium,
    onSecondaryContainer = TitaniumPlatinum,
    tertiary = TitaniumSilver,
    onTertiary = ObsidianBlack,
    background = ObsidianBlack,
    onBackground = TitaniumPlatinum,
    surface = ObsidianSurface,
    onSurface = TitaniumPlatinum,
    surfaceVariant = TitaniumDark,
    onSurfaceVariant = TitaniumSilver,
    outline = TitaniumLight,
    outlineVariant = TitaniumBrushed,
    error = StatusAlertRed,
    onError = ObsidianBlack
)

@Composable
fun ObsydianTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                window.statusBarColor = ObsidianBlack.toArgb()
                window.navigationBarColor = ObsidianBlack.toArgb()
                val controller = WindowCompat.getInsetsController(window, view)
                controller.isAppearanceLightStatusBars = false
                controller.isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = ObsydianColorScheme,
        typography = ObsydianTypography,
        content = content
    )
}
