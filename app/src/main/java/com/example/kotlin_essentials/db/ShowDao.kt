package com.example.kotlin_essentials.db

import androidx.room.Dao
import androidx.room.Insert
import com.example.kotlin_essentials.data.models.TvShowResponseItem

@Dao
interface ShowDao {

    @Insert
    suspend fun addShows(show: TvShowResponseItem)

}