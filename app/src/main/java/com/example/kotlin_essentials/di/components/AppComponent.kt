package com.example.kotlin_essentials.di.components

import android.content.Context
import com.example.kotlin_essentials.di.modules.DatabaseModule
import com.example.kotlin_essentials.di.modules.NetworkModule
import com.example.kotlin_essentials.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun createContext(@BindsInstance context: Context) : AppComponent
    }
}