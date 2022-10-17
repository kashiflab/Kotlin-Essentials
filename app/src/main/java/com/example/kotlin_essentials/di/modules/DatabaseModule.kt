package com.example.kotlin_essentials.di.modules

import android.content.Context
import androidx.room.Room
import com.example.kotlin_essentials.db.ShowDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesShowDB(context: Context): ShowDB{
        return Room.databaseBuilder(context, ShowDB::class.java, "Show").build()
    }

}