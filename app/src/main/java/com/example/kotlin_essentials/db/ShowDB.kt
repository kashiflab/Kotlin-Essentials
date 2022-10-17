package com.example.kotlin_essentials.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin_essentials.data.models.TvShowResponseItem

@Database(entities = [TvShowResponseItem::class], version = 1)
abstract class ShowDB: RoomDatabase() {

    abstract fun getShowDao() : ShowDao
}