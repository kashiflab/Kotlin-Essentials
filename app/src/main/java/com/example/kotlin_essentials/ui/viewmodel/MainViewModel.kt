package com.example.kotlin_essentials.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_essentials.data.models.TvShowResponse
import com.example.kotlin_essentials.data.repository.ShowRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ShowRepository): ViewModel() {
    val shows : LiveData<TvShowResponse>
    get() = repository.shows

    init {
        viewModelScope.launch {
            repository.getShows()
        }
    }
}