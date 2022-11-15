package com.example.paygambarlartarixi.database

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val name:String,
    val image:Int,
): Parcelable
