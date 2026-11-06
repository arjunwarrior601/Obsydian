package com.obsydian.ui.permissions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat

object PermissionManager {

    /**
     * Returns the required media permissions corresponding to the running Android OS version:
     * - Android 13 (Tiramisu / API 33) and above: Granular media permissions (Audio, Video, Images)
     * - Android 12 (API 32) and below: READ_EXTERNAL_STORAGE
     */
    fun getRequiredMediaPermissions(): Array<String> {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.READ_MEDIA_VIDEO,
                Manifest.permission.READ_MEDIA_IMAGES
            )
        } else {
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
    }

    /**
     * Checks if all required media permissions are granted.
     */
    fun hasMediaPermissions(context: Context): Boolean {
        val permissions = getRequiredMediaPermissions()
        return permissions.all { permission ->
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        }
    }
}
