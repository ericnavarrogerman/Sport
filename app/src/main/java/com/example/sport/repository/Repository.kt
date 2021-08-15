package com.example.sport.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sport.model.ResponseApi
import com.example.sport.model.Teams
import com.example.sport.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject



class Repository @Inject constructor(var apiClient: ApiClient){


    val _teams= MutableLiveData<List<Teams>>()



    fun getTeamsForLeague(idLeague:String){

        var call =apiClient.getTeamsForLeague(idLeague)

        call.enqueue(object :Callback<ResponseApi>{
            override fun onResponse(
                call: Call<ResponseApi>,
                response: Response<ResponseApi>
            ) {




                if (response.isSuccessful && response.body() !=null){
                    _teams.value =response.body()!!.teams
                }
            }

            override fun onFailure(call: Call<ResponseApi>, t: Throwable) {
                Log.e("retrofit",t.message!!)
            }

        })



    }





}