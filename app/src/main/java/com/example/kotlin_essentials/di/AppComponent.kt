package com.example.kotlin_essentials.di

import com.example.kotlin_essentials.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}