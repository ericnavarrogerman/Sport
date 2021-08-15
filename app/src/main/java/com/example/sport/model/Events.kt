package com.example.sport.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parceler


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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(home)
        parcel.writeString(away)
        parcel.writeString(date)
        parcel.writeString(hour)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Events> {
        override fun createFromParcel(parcel: Parcel): Events {
            return Events(parcel)
        }

        override fun newArray(size: Int): Array<Events?> {
            return arrayOfNulls(size)
        }
    }
}
