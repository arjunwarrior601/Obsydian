package com.obsydian.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.obsydian.theme.ObsidianBlack
import com.obsydian.theme.ObsydianTypography
import com.obsydian.theme.StatusAlertRed
import com.obsydian.theme.StatusOfflineGreen
import com.obsydian.theme.StatusPendingAmber
import com.obsydian.theme.TitaniumLight

enum class BadgeStyle {
    OFFLINE,
    NOT_IMPLEMENTED,
    ALERT,
    TITANIUM
}

@Composable
fun ObsydianStatusBadge(
    text: String,
    style: BadgeStyle = BadgeStyle.NOT_IMPLEMENTED,
    modifier: Modifier = Modifier
) {
    val (dotColor, borderColor, textColor, bgColor) = when (style) {
        BadgeStyle.OFFLINE -> Quadruple(
            StatusOfflineGreen,
            StatusOfflineGreen.copy(alpha = 0.5f),
            StatusOfflineGreen,
            StatusOfflineGreen.copy(alpha = 0.12f)
        )
        BadgeStyle.NOT_IMPLEMENTED -> Quadruple(
            StatusPendingAmber,
            StatusPendingAmber.copy(alpha = 0.5f),
            StatusPendingAmber,
            StatusPendingAmber.copy(alpha = 0.12f)
        )
        BadgeStyle.ALERT -> Quadruple(
            StatusAlertRed,
            StatusAlertRed.copy(alpha = 0.5f),
            StatusAlertRed,
            StatusAlertRed.copy(alpha = 0.12f)
        )
        BadgeStyle.TITANIUM -> Quadruple(
            TitaniumLight,
            TitaniumLight,
            Color(0xFFB0B7C6),
            Color(0xFF1E222A)
        )
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(6.dp))
            .padding(horizontal = 8.dp, vertical = 3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .clip(CircleShape)
                .background(dotColor)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = text,
            style = ObsydianTypography.labelSmall,
            color = textColor
        )
    }
}

private data class Quadruple<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
)
