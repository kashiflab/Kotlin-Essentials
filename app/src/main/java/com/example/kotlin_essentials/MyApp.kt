package com.example.kotlin_essentials

import android.app.Application
import com.example.kotlin_essentials.di.components.AppComponent
import com.example.kotlin_essentials.di.components.DaggerAppComponent

class MyApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().createContext(this)
    }

}