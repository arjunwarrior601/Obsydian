package com.obsydian.ui.placeholders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.obsydian.components.BadgeStyle
import com.obsydian.components.ObsydianCard
import com.obsydian.components.ObsydianStatusBadge
import com.obsydian.theme.ElectricBluePrimary
import com.obsydian.theme.ObsydianTypography
import com.obsydian.theme.TitaniumPlatinum
import com.obsydian.theme.TitaniumSilver

@Composable
fun VideoPlaceholderScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Main Placeholder Card
        ObsydianCard(
            modifier = Modifier.fillMaxWidth(),
            hasAccentBorder = true
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.VideoLibrary,
                        contentDescription = "Video Section",
                        tint = ElectricBluePrimary,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "VIDEO PLAYER",
                        style = ObsydianTypography.titleLarge,
                        color = TitaniumPlatinum
                    )
                }
                ObsydianStatusBadge(
                    text = "NOT IMPLEMENTED YET",
                    style = BadgeStyle.NOT_IMPLEMENTED
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Video playback engine is scheduled for development in Phase 2. No mock, fake, or synthetic video files are shown in this build to uphold data accuracy.",
                style = ObsydianTypography.bodyLarge,
                color = TitaniumSilver
            )
        }

        // Upcoming Architecture Overview Card
        ObsydianCard(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Roadmap Info",
                    tint = ElectricBluePrimary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "PLANNED CAPABILITIES (PHASE 2)",
                    style = ObsydianTypography.labelLarge,
                    color = TitaniumPlatinum
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                PlannedFeatureItem("Media3 ExoPlayer core with hardware acceleration")
                PlannedFeatureItem("Local MKV, MP4, WebM, and AVI container decoding")
                PlannedFeatureItem("Embedded & external subtitle rendering (SRT, ASS, VTT)")
                PlannedFeatureItem("Gesture-based brightness and volume scrubbing")
                PlannedFeatureItem("Variable playback speed (0.25x - 3.0x) with pitch correction")
            }
        }
    }
}

@Composable
fun PlannedFeatureItem(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.PlayCircleOutline,
            contentDescription = null,
            tint = ElectricBluePrimary,
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = ObsydianTypography.bodyMedium,
            color = TitaniumSilver
        )
    }
}
