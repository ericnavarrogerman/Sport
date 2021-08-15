package com.example.sport.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName




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
    @SerializedName("strTeamJersey")
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

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(foundationYear)
        parcel.writeString(badge)
        parcel.writeString(stadium)
        parcel.writeString(jersey)
        parcel.writeString(pageWeb)
        parcel.writeString(facebook)
        parcel.writeString(twitter)
        parcel.writeString(youtube)
        parcel.writeString(instagram)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Teams> {
        override fun createFromParcel(parcel: Parcel): Teams {
            return Teams(parcel)
        }

        override fun newArray(size: Int): Array<Teams?> {
            return arrayOfNulls(size)
        }
    }
}


data class ResponseApi(
    @SerializedName("teams")
    var teams: ArrayList<Teams> = ArrayList()
)