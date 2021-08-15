package com.example.sport.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable
