package com.gearcheckapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val GearCheckColors = lightColorScheme(
    primary = TealPrimary
)

@Composable
fun GearCheckTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = GearCheckColors,
        typography = Typography,
        content = content
    )
}