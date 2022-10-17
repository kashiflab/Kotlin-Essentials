package com.example.kotlin_essentials.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_essentials.data.api.APIService
import com.example.kotlin_essentials.data.models.TvShowResponse
import com.example.kotlin_essentials.data.models.TvShowResponseItem
import com.example.kotlin_essentials.db.ShowDB
import javax.inject.Inject

class ShowRepository @Inject constructor(private val apiService: APIService, private val showDB: ShowDB) {

    private val _shows = MutableLiveData<TvShowResponse>()
    val shows : LiveData<TvShowResponse>
    get() = _shows

    suspend fun getShows(){

        val showFromDB = showDB.getShowDao().getShows()
        if(showFromDB.isEmpty()){
            val result = apiService.getAllShows()
            if(result.isSuccessful && result.body()!=null){
                result.body()!!.forEach{
                    showDB.getShowDao().addShows(it)
                }
                _shows.postValue(result.body())
            }
        }else{
            val showResponse = TvShowResponse()
            showResponse.addAll(showFromDB)
            _shows.postValue(showResponse)
        }

    }
}