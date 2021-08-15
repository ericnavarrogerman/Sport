package com.example.sport.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teams(
    @SerializedName("idTeam")
    var id:String,
    @SerializedName("strTeam")
    var name:String,
    @SerializedName("strDescriptionEN")
    var description:String,
    @SerializedName("intFormedYear")
    var foundationYear:String,
    @SerializedName("strTeamBadge")
    var badge:String,
    @SerializedName("strStadium")
    var stadium:String,
    @SerializedName("strJersey")
    var jersey:String,

    @SerializedName("strWebsite")
    var pageWeb:String,
    @SerializedName("strFacebook")
    var facebook:String,
    @SerializedName("strTwitter")
    var twitter:String,
    @SerializedName("strYoutube")
    var youtube:String,
    @SerializedName("strInstagram")
    var instagram:String,

    var events: ArrayList<Events> = ArrayList()

) : Parcelable


data class ResponseApi(
    @SerializedName("teams")
    var teams: ArrayList<Teams> = ArrayList()
)