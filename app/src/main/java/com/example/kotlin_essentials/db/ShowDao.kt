package com.example.kotlin_essentials.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kotlin_essentials.data.models.TvShowResponseItem

@Dao
interface ShowDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addShows(show: TvShowResponseItem)

}