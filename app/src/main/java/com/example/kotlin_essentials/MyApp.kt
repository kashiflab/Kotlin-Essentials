package com.example.kotlin_essentials

import android.app.Application
import android.content.Context
import com.example.kotlin_essentials.di.AppComponent
import com.example.kotlin_essentials.di.DaggerAppComponent

class MyApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }

}