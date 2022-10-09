package com.codelab.theming.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun JetnewsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        typography = JetnewsTypography,
        content = content)
}