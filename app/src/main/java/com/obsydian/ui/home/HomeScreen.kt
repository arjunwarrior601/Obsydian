package com.obsydian.ui.home

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.obsydian.components.ObsydianTopBar
import com.obsydian.theme.ElectricBluePrimary
import com.obsydian.theme.ElectricBlueSurface
import com.obsydian.theme.ObsidianBlack
import com.obsydian.theme.ObsydianTypography
import com.obsydian.theme.TitaniumLight
import com.obsydian.theme.TitaniumPlatinum
import com.obsydian.theme.TitaniumSilver
import com.obsydian.ui.permissions.PermissionBanner
import com.obsydian.ui.permissions.PermissionManager
import com.obsydian.ui.placeholders.FilesPlaceholderScreen
import com.obsydian.ui.placeholders.MusicPlaceholderScreen
import com.obsydian.ui.placeholders.PhotosPlaceholderScreen
import com.obsydian.ui.placeholders.VideoPlaceholderScreen

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var currentSection by remember { mutableStateOf(HomeSection.VIDEO) }
    var hasPermission by remember { mutableStateOf(PermissionManager.hasMediaPermissions(context)) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { results ->
        // Any granted permissions update state
        hasPermission = PermissionManager.hasMediaPermissions(context)
    }

    // Refresh permission status when returning to foreground
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                hasPermission = PermissionManager.hasMediaPermissions(context)
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Scaffold(
        containerColor = ObsidianBlack,
        topBar = {
            ObsydianTopBar(subtitle = currentSection.subtitle)
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ObsidianBlack)
            ) {
                // Titanium metallic hairline separator
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(TitaniumLight)
                )

                NavigationBar(
                    containerColor = ObsidianBlack,
                    tonalElevation = 0.dp,
                    modifier = Modifier.navigationBarsPadding()
                ) {
                    HomeSection.entries.forEach { section ->
                        val isSelected = currentSection == section
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = { currentSection = section },
                            icon = {
                                Icon(
                                    imageVector = section.icon,
                                    contentDescription = section.title,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            label = {
                                Text(
                                    text = section.title.uppercase(),
                                    style = ObsydianTypography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    letterSpacing = 0.75.sp
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = ElectricBluePrimary,
                                selectedTextColor = ElectricBluePrimary,
                                unselectedIconColor = TitaniumSilver,
                                unselectedTextColor = TitaniumSilver,
                                indicatorColor = ElectricBlueSurface
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Permission Banner: Always visible if permissions need granting or for status confirmation
            PermissionBanner(
                isGranted = hasPermission,
                onRequestPermission = {
                    permissionLauncher.launch(PermissionManager.getRequiredMediaPermissions())
                },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )

            // Section Placeholder Views
            Crossfade(
                targetState = currentSection,
                label = "SectionCrossfade",
                modifier = Modifier.weight(1f)
            ) { section ->
                when (section) {
                    HomeSection.VIDEO -> VideoPlaceholderScreen()
                    HomeSection.MUSIC -> MusicPlaceholderScreen()
                    HomeSection.PHOTOS -> PhotosPlaceholderScreen()
                    HomeSection.FILES -> FilesPlaceholderScreen()
                }
            }
        }
    }
}
