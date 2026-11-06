package com.obsydian.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeSection(
    val title: String,
    val icon: ImageVector,
    val subtitle: String
) {
    VIDEO("Video", Icons.Default.VideoLibrary, "Media3 Player"),
    MUSIC("Music", Icons.Default.Audiotrack, "Audio Library"),
    PHOTOS("Photos", Icons.Default.PhotoLibrary, "Photo Gallery"),
    FILES("Files", Icons.Default.Folder, "File Explorer")
}
