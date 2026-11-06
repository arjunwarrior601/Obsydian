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
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PhotoLibrary
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
fun PhotosPlaceholderScreen(modifier: Modifier = Modifier) {
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
                        imageVector = Icons.Default.PhotoLibrary,
                        contentDescription = "Photos Section",
                        tint = ElectricBluePrimary,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "PHOTO GALLERY",
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
                text = "Photo viewer and gallery management are scheduled for future development phases. No dummy pictures or placeholder stock galleries are displayed.",
                style = ObsydianTypography.bodyLarge,
                color = TitaniumSilver
            )
        }

        // Planned Photo Capabilities
        ObsydianCard(modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Photo Roadmap Info",
                    tint = ElectricBluePrimary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "PLANNED GALLERY CAPABILITIES",
                    style = ObsydianTypography.labelLarge,
                    color = TitaniumPlatinum
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                PlannedPhotoItem("Full-fidelity RAW (DNG), JPEG, PNG, WEBP, and AVIF viewer")
                PlannedPhotoItem("Pinch-to-zoom with sub-pixel hardware precision")
                PlannedPhotoItem("On-device EXIF metadata inspection (camera, lens, ISO)")
                PlannedPhotoItem("Timeline & directory-based chronological grouping")
                PlannedPhotoItem("Zero-recompression policy preserving original file hashes")
            }
        }
    }
}

@Composable
fun PlannedPhotoItem(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.Image,
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
