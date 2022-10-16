package com.example.kotlin_essentials.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_essentials.data.api.APIService
import com.example.kotlin_essentials.data.models.TvShowResponse
import com.example.kotlin_essentials.data.models.TvShowResponseItem
import javax.inject.Inject

class ShowRepository @Inject constructor(private val apiService: APIService) {

    private val _products = MutableLiveData<TvShowResponse>()
    val products : LiveData<TvShowResponse>
    get() = _products

    suspend fun getShows(){
        val result = apiService.getAllShows()
        if(result.isSuccessful && result.body()!=null){
            _products.postValue(result.body())
        }else{

        }
    }
}