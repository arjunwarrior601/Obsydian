package com.obsydian.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.obsydian.theme.ElectricBluePrimary
import com.obsydian.theme.TitaniumBorderGradient
import com.obsydian.theme.TitaniumCardGradient
import com.obsydian.theme.TitaniumLight

@Composable
fun ObsydianCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(14.dp),
    hasAccentBorder: Boolean = false,
    contentPadding: Dp = 16.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    val borderBrush = if (hasAccentBorder) {
        Brush.horizontalGradient(
            colors = listOf(
                ElectricBluePrimary,
                TitaniumLight,
                ElectricBluePrimary.copy(alpha = 0.3f)
            )
        )
    } else {
        TitaniumBorderGradient
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(TitaniumCardGradient)
            .border(width = 1.dp, brush = borderBrush, shape = shape)
    ) {
        if (hasAccentBorder) {
            // Subtle electric-blue top accent stripe
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(ElectricBluePrimary)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding)
        ) {
            content()
        }
    }
}
