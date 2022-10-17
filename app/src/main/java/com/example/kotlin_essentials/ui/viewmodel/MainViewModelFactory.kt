package com.example.kotlin_essentials.ui.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_essentials.data.repository.ShowRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: ShowRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}