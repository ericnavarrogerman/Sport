package com.example.sport.service

import com.example.sport.model.Events
import com.example.sport.model.ResponseApi
import com.example.sport.model.Teams
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface SportService {


    companion object{

        const val BASE_URL="https://www.thesportsdb.com/api/v1/json/"

        const val SEARCH_ALL_TEAMS ="1/search_all_teams.php"

        const val SEARCH_EVENTOS="1/eventslast.php"
    }



    @GET(SEARCH_ALL_TEAMS)
  fun getTeamsForLeague(
        @Query("s") sport:String,
        @Query("c") country:String

  ): Call<ResponseApi>


  @GET(SEARCH_EVENTOS)
  fun getEventForId(@Query("id") idTeam: String): Call<List<Events>>




}