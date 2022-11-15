package com.example.paygambarlartarixi

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap

class MyImageManager (private val context: Context){

    fun setImage(image: Bitmap){
        val wallpaperManager = context.getSystemService(Context.WALLPAPER_SERVICE) as WallpaperManager
        wallpaperManager.setBitmap(image)
    }

}