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
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.obsydian.components.BadgeStyle
import com.obsydian.components.ObsydianCard
import com.obsydian.components.ObsydianStatusBadge
import com.obsydian.theme.ElectricBluePrimary
import com.obsydian.theme.ObsydianTypography
import com.obsydian.theme.TitaniumPlatinum
import com.obsydian.theme.TitaniumSilver

@Composable
fun MusicPlaceholderScreen(modifier: Modifier = Modifier) {
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
                        imageVector = Icons.Default.Audiotrack,
                        contentDescription = "Music Section",
                        tint = ElectricBluePrimary,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "MUSIC & AUDIO",
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
                text = "Audio player and library scanner are scheduled for development in upcoming phases. In accordance with honesty principles, no simulated tracks or mock artist lists are shown.",
                style = ObsydianTypography.bodyLarge,
                color = TitaniumSilver
            )
        }

        // Planned Audio Capabilities
        ObsydianCard(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Audio Info",
                    tint = ElectricBluePrimary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "PLANNED AUDIO CAPABILITIES",
                    style = ObsydianTypography.labelLarge,
                    color = TitaniumPlatinum
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                PlannedAudioItem("MediaSession background playback service")
                PlannedAudioItem("High-resolution FLAC, ALAC, WAV, MP3, AAC decoding")
                PlannedAudioItem("Lockscreen media controls & notification player")
                PlannedAudioItem("Local ID3 metadata extraction & embedded album artwork")
                PlannedAudioItem("Dynamic playlist queues with zero disk alteration")
            }
        }
    }
}

@Composable
fun PlannedAudioItem(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.MusicNote,
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
