package com.example.sport.model

import com.google.gson.annotations.SerializedName

data class Events(
    @SerializedName("idEvent")
    var id:String,
    @SerializedName("strFilename")
    var name:String,
    @SerializedName("strHomeTeam")
    var home:String,
    @SerializedName("strAwayTeam")
    var away:String,
    @SerializedName("dateEvent")
    var date:String,
    @SerializedName("strTime")
    var hour:String
)
