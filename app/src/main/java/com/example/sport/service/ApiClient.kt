package com.example.sport.service

import com.example.sport.BuildConfig
import com.example.sport.service.SportService.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {


private val apiInterface :SportService by lazy {

    getRetrofitBuilder(BASE_URL).create(SportService::class.java)

}


  private fun getRetrofitBuilder(
      url: String

  ) = Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create())
      .baseUrl(url)
      .build()


    suspend fun getTeamsForLeague(idLeague:String) = apiInterface.getTeamsForLeague(idLeague)

    suspend fun getEventForIdTeam(idTeam:String) = apiInterface.getEventForId(idTeam)


}