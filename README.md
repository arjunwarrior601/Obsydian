# OBSYDIAN — Native Android Media Player & File Manager

> **"Beyond Playback"**
> Premium, fully offline native Android media player and file manager engineered with titanium aesthetics and electric-blue accents.

---

## Architecture & Concept

OBSYDIAN is designed strictly as an offline-first, privacy-respecting media hub:
- **Zero Internet Access:** No `android.permission.INTERNET` declared. No telemetry, ads, cloud synchronisation, accounts, or third-party tracking.
- **Safety Guarantee:** Strict read-only discovery in media phases. User files are never deleted or overwritten automatically.
- **Titanium + Electric Blue Design:** Obsidian void backgrounds (`#08090C`), metallic titanium card surfaces (`#161920` - `#2E3342`), and vivid electric-blue accents (`#00E5FF`).

---

## Tech Stack (Phase 1 Foundation)

- **Language:** Kotlin 2.0.21
- **UI Framework:** Jetpack Compose with Material 3 (BOM `2024.10.01`)
- **Architecture:** Single Activity (`MainActivity.kt`)
- **Media Engine Base:** AndroidX Media3 (ExoPlayer + MediaSession `1.5.0`)
- **SDK Targets:** `minSdk 26` (Android 8.0 Oreo), `targetSdk 35` (Android 15)
- **Dependency Management:** Gradle Version Catalog (`gradle/libs.versions.toml`)

---

## Project Structure

```text
obsydian/
├── gradle/
│   ├── libs.versions.toml             # Version catalog (Compose, Media3, AGP, Kotlin)
│   └── wrapper/
│       └── gradle-wrapper.properties  # Gradle 8.10.2 configuration
├── app/
│   ├── build.gradle.kts               # Module build configuration (minSdk 26, targetSdk 35)
│   ├── proguard-rules.pro             # Proguard keep rules
│   └── src/main/
│       ├── AndroidManifest.xml        # Manifest (No Internet, scoped media permissions)
│       ├── java/com/obsydian/
│       │   ├── MainActivity.kt        # Single activity entry point
│       │   ├── theme/
│       │   │   ├── Color.kt           # Titanium, obsidian, and electric blue palette
│       │   │   ├── Type.kt            # Typography definitions
│       │   │   └── Theme.kt           # ObsydianTheme Material 3 wrapper
│       │   ├── components/
│       │   │   ├── ObsydianTopBar.kt  # Header bar with "OFFLINE" indicator
│       │   │   ├── ObsydianButton.kt  # Electric blue & metallic action buttons
│       │   │   ├── ObsydianCard.kt    # Titanium metallic card containers
│       │   │   └── ObsydianStatusBadge.kt # Status pills (Offline, Pending, Alert)
│       │   ├── ui/
│       │   │   ├── home/
│       │   │   │   ├── HomeSection.kt # 4 primary sections: Video, Music, Photos, Files
│       │   │   │   └── HomeScreen.kt  # Navigation, permission banner, section routing
│       │   │   ├── permissions/
│       │   │   │   ├── PermissionManager.kt # Version-scoped permission queries
│       │   │   │   └── PermissionBanner.kt  # In-app permission request banner
│       │   │   └── placeholders/
│       │   │       ├── VideoPlaceholderScreen.kt  # Labeled "NOT IMPLEMENTED YET"
│       │   │       ├── MusicPlaceholderScreen.kt  # Labeled "NOT IMPLEMENTED YET"
│       │   │       ├── PhotosPlaceholderScreen.kt # Labeled "NOT IMPLEMENTED YET"
│       │   │       └── FilesPlaceholderScreen.kt  # Labeled "NOT IMPLEMENTED YET"
│       └── res/
│           ├── drawable/
│           │   ├── ic_launcher_background.xml # Faceted titanium background
│           │   ├── ic_launcher_foreground.xml # Electric blue gemstone core
│           │   └── ic_obsydian_logo.xml       # Top bar brand emblem
│           ├── mipmap-anydpi-v26/
│           │   ├── ic_launcher.xml            # Adaptive launcher icon
│           │   └── ic_launcher_round.xml      # Round adaptive icon
│           └── values/
│               ├── colors.xml
│               ├── strings.xml
│               └── themes.xml
├── build.gradle.kts                   # Top-level build script
├── settings.gradle.kts                # Project name & repository settings
├── gradle.properties                  # JVM args & AndroidX flags
├── gradlew                            # Unix Gradle wrapper executable
└── gradlew.bat                        # Windows Gradle wrapper batch script
```

---

## Media Permissions Handling

Permissions are handled dynamically according to Android platform level:

| Android Version | Permissions Requested | Purpose |
|:---|:---|:---|
| **Android 13+ (API 33+)** | `READ_MEDIA_AUDIO`<br/>`READ_MEDIA_VIDEO`<br/>`READ_MEDIA_IMAGES` | Scoped access strictly to media types |
| **Android 8.0 - 12 (API 26–32)** | `READ_EXTERNAL_STORAGE` (`maxSdkVersion="32"`) | Legacy external media reading |

No internet or broad network permissions are ever requested.

---

## Build and Installation Instructions

### Prerequisites
- JDK 17 or JDK 21 installed (`JAVA_HOME` set)
- Android SDK with platform `android-35` and build-tools installed (or Android Studio Ladybug/Koala+)

### Steps to Build Debug APK
1. Clone or extract the project directory:
   ```bash
   cd obsydian
   ```
2. Build the debug APK via Gradle:
   ```bash
   ./gradlew assembleDebug
   ```
   *(On Windows: `gradlew.bat assembleDebug`)*

3. The generated debug APK will be located at:
   ```text
   app/build/outputs/apk/debug/app-debug.apk
   ```

### Steps to Install on Device / Emulator
1. Connect device via USB with USB debugging enabled (or start an Android emulator).
2. Install the APK via ADB:
   ```bash
   adb install -r app/build/outputs/apk/debug/app-debug.apk
   ```
   *Or directly run via Gradle:*
   ```bash
   ./gradlew installDebug
   ```
3. Launch the app:
   ```bash
   adb shell am start -n com.obsydian.debug/com.obsydian.MainActivity
   ```
