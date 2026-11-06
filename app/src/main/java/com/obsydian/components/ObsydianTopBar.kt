package com.obsydian.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.obsydian.R
import com.obsydian.theme.ElectricBluePrimary
import com.obsydian.theme.ObsidianBlack
import com.obsydian.theme.ObsydianTypography
import com.obsydian.theme.TitaniumBrushed
import com.obsydian.theme.TitaniumLight
import com.obsydian.theme.TitaniumPlatinum
import com.obsydian.theme.TitaniumSilver

@Composable
fun ObsydianTopBar(
    subtitle: String = "Beyond Playback",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(ObsidianBlack)
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Brand Logo & Title
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_obsydian_logo),
                    contentDescription = "OBSYDIAN Logo",
                    modifier = Modifier.size(34.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "OBSYDIAN",
                            style = ObsydianTypography.titleLarge,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 2.sp,
                            color = TitaniumPlatinum
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .size(5.dp)
                                .background(ElectricBluePrimary)
                        )
                    }
                    Text(
                        text = subtitle.uppercase(),
                        style = ObsydianTypography.labelSmall,
                        color = TitaniumSilver,
                        letterSpacing = 1.2.sp
                    )
                }
            }

            // Offline Privacy Indicator Badge
            ObsydianStatusBadge(
                text = "OFFLINE",
                style = BadgeStyle.OFFLINE
            )
        }

        // Metallic Brushed Bottom Seam Divider
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(TitaniumLight)
        )
    }
}
