package com.example.sport.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sport.model.Events
import com.example.sport.model.ResponseApi
import com.example.sport.model.ResponseEvents
import com.example.sport.model.Teams
import com.example.sport.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject



class Repository @Inject constructor(var apiClient: ApiClient){

     suspend fun getTeamsForLeague(idLeague:String) = apiClient.getTeamsForLeague(idLeague)
     suspend fun getEventForIdTeam(id:String) = apiClient.getEventForIdTeam(id)


}