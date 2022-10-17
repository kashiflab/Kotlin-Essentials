package com.example.kotlin_essentials.data.models

import androidx.room.Entity

//@Entity(tableName = "Image")
data class Image(
    val medium: String,
    val original: String
)