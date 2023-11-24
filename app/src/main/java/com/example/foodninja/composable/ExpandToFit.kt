package com.example.foodninja.composable

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


// this function will take the remaining space of screen
@Composable
fun ColumnScope.ExpandToFit() {
    Spacer(modifier = Modifier.weight(1f))
}