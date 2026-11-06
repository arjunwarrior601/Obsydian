package com.obsydian.ui.permissions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.obsydian.components.BadgeStyle
import com.obsydian.components.ObsydianButton
import com.obsydian.components.ObsydianCard
import com.obsydian.components.ObsydianStatusBadge
import com.obsydian.theme.ElectricBluePrimary
import com.obsydian.theme.ObsydianTypography
import com.obsydian.theme.StatusOfflineGreen
import com.obsydian.theme.TitaniumPlatinum
import com.obsydian.theme.TitaniumSilver

@Composable
fun PermissionBanner(
    isGranted: Boolean,
    onRequestPermission: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (!isGranted) {
        ObsydianCard(
            modifier = modifier,
            hasAccentBorder = true
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Permission Required",
                        tint = ElectricBluePrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "LOCAL STORAGE ACCESS",
                        style = ObsydianTypography.titleMedium,
                        color = TitaniumPlatinum
                    )
                }
                ObsydianStatusBadge(
                    text = "ACTION REQUIRED",
                    style = BadgeStyle.ALERT
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "OBSYDIAN operates strictly offline with zero network connectivity. Storage permissions are required solely to discover and index your on-device video, audio, and photo files.",
                style = ObsydianTypography.bodyMedium,
                color = TitaniumSilver
            )

            Spacer(modifier = Modifier.height(14.dp))

            ObsydianButton(
                text = "Grant Media Access",
                onClick = onRequestPermission,
                modifier = Modifier.fillMaxWidth()
            )
        }
    } else {
        ObsydianCard(
            modifier = modifier,
            contentPadding = 12.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Access Granted",
                        tint = StatusOfflineGreen
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Storage Access Granted",
                            style = ObsydianTypography.titleSmall,
                            color = TitaniumPlatinum
                        )
                        Text(
                            text = "Media files accessible for local offline playback",
                            style = ObsydianTypography.labelSmall,
                            color = TitaniumSilver
                        )
                    }
                }
                ObsydianStatusBadge(
                    text = "ACTIVE",
                    style = BadgeStyle.OFFLINE
                )
            }
        }
    }
}
