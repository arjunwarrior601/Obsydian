package com.obsydian.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.obsydian.theme.ElectricBlueDark
import com.obsydian.theme.ElectricBlueGradient
import com.obsydian.theme.ElectricBluePrimary
import com.obsydian.theme.ObsidianBlack
import com.obsydian.theme.ObsydianTypography
import com.obsydian.theme.TitaniumBorderGradient
import com.obsydian.theme.TitaniumDark
import com.obsydian.theme.TitaniumLight
import com.obsydian.theme.TitaniumPlatinum
import com.obsydian.theme.TitaniumSilver

@Composable
fun ObsydianButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true
) {
    val shape = RoundedCornerShape(10.dp)
    val backgroundBrush = if (enabled) {
        ElectricBlueGradient
    } else {
        Brush.linearGradient(listOf(TitaniumDark, TitaniumLight))
    }

    Box(
        modifier = modifier
            .defaultMinSize(minHeight = 46.dp)
            .clip(shape)
            .background(backgroundBrush)
            .clickable(
                enabled = enabled,
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = ObsidianBlack)
            )
            .padding(horizontal = 20.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (leadingIcon != null) {
                leadingIcon()
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text.uppercase(),
                style = ObsydianTypography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = if (enabled) ObsidianBlack else TitaniumSilver
            )
        }
    }
}

@Composable
fun ObsydianOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    highlight: Boolean = false
) {
    val borderColor = if (highlight) ElectricBluePrimary else TitaniumLight
    val textColor = if (highlight) ElectricBluePrimary else TitaniumPlatinum

    OutlinedButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minHeight = 44.dp),
        enabled = enabled,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = textColor,
            disabledContentColor = TitaniumSilver
        ),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp)
    ) {
        if (leadingIcon != null) {
            leadingIcon()
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text,
            style = ObsydianTypography.labelLarge,
            color = if (enabled) textColor else TitaniumSilver
        )
    }
}
