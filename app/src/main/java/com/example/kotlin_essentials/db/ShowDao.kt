package com.example.kotlin_essentials.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin_essentials.data.models.TvShowResponseItem

@Dao
interface ShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShows(show: TvShowResponseItem)

    @Query("SELECT * FROM TvShow")
    suspend fun getShows() : List<TvShowResponseItem>

}