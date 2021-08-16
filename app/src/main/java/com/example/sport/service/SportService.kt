package com.example.sport.service

import com.example.sport.model.Events
import com.example.sport.model.ResponseApi
import com.example.sport.model.ResponseEvents
import com.example.sport.model.Teams
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SportService {


    companion object{

        const val BASE_URL="https://www.thesportsdb.com/api/v1/json/"

        const val SEARCH_ALL_TEAMS ="1/lookup_all_teams.php"

        const val SEARCH_EVENTOS="1/eventslast.php"
    }



    @GET(SEARCH_ALL_TEAMS)
  suspend fun getTeamsForLeague(@Query("id") idLeague:String): Response<ResponseApi>


  @GET(SEARCH_EVENTOS)
  suspend fun getEventForId(@Query("id") idTeam: String): Response<ResponseEvents>




}