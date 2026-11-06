package com.obsydian.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// ==========================================
// OBSYDIAN: Titanium + Electric Blue Palette
// ==========================================

// Obsidian / Graphite Deep Backgrounds
val ObsidianBlack = Color(0xFF08090C)         // Purest abyss black for base backgrounds
val ObsidianSurface = Color(0xFF101216)       // Primary surface / container background
val TitaniumDark = Color(0xFF161920)          // Secondary card surface
val TitaniumMedium = Color(0xFF222630)        // Elevated cards / headers
val TitaniumLight = Color(0xFF2E3342)         // Outlines, borders, structural dividers
val TitaniumBrushed = Color(0xFF454B5C)       // Metallic sheen & edge highlights
val TitaniumSilver = Color(0xFF8E95A5)        // Subdued secondary text, inactive glyphs
val TitaniumPlatinum = Color(0xFFE2E6EF)      // High-contrast crisp metallic body text
val TitaniumWhite = Color(0xFFF7F8FA)         // Pure bright text & focused highlights

// Electric Blue Accents (Vivid Neon Cyan)
val ElectricBluePrimary = Color(0xFF00E5FF)   // Brand highlight / primary accent
val ElectricBlueSecondary = Color(0xFF00B0FF) // Secondary gradient partner
val ElectricBlueDark = Color(0xFF0072B2)      // Pressed state & subtle container fills
val ElectricBlueGlow = Color(0x3300E5FF)      // 20% alpha glow halo
val ElectricBlueSurface = Color(0x1500E5FF)   // Subtle electric-blue card tint (8%)

// System & Offline State Colors
val StatusOfflineGreen = Color(0xFF00E676)    // Strictly offline / secure indicator
val StatusPendingAmber = Color(0xFFFFB300)    // Permission / implementation pending
val StatusAlertRed = Color(0xFFFF5252)        // Errors or missing permissions

// Reusable Titanium & Electric Blue Metallic Brushes
val MetallicTitaniumBrush = Brush.linearGradient(
    colors = listOf(
        Color(0xFF252A36),
        Color(0xFF384052),
        Color(0xFF1F232D)
    )
)

val TitaniumCardGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF191C24),
        Color(0xFF101217)
    )
)

val ElectricBlueGradient = Brush.horizontalGradient(
    colors = listOf(
        Color(0xFF00E5FF),
        Color(0xFF0091EA)
    )
)

val TitaniumBorderGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF454D61),
        Color(0xFF1E222B),
        Color(0xFF3C4456)
    )
)
