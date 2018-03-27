package com.omar.tajawaltask.app.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
data class Hotel(
        @SerializedName("hotelId") val id: Long,
        @SerializedName("image") val images: List<Image>,
        @SerializedName("location") val location: Location,
        @SerializedName("summary") val summary: Summary) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.createTypedArrayList(Image),
            parcel.readParcelable(Location::class.java.classLoader),
            parcel.readParcelable(Summary::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeTypedList(images)
        parcel.writeParcelable(location, flags)
        parcel.writeParcelable(summary, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hotel> {
        override fun createFromParcel(parcel: Parcel): Hotel {
            return Hotel(parcel)
        }

        override fun newArray(size: Int): Array<Hotel?> {
            return arrayOfNulls(size)
        }
    }

}


data class Image(@SerializedName("url") val url: String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: Parcel): Image {
            return Image(parcel)
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }

}

data class Location(@SerializedName("address") val address: String,
                    @SerializedName("latitude") val lat: Double,
                    @SerializedName("longitude") val lng: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readDouble(),
            parcel.readDouble()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(address)
        parcel.writeDouble(lat)
        parcel.writeDouble(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }

}

data class Summary(@SerializedName("highRate") val highRate: Double,
                   @SerializedName("hotelName") val name: String,
                   @SerializedName("lowRate") val lowRate: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readDouble(),
            parcel.readString(),
            parcel.readDouble()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(highRate)
        parcel.writeString(name)
        parcel.writeDouble(lowRate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Summary> {
        override fun createFromParcel(parcel: Parcel): Summary {
            return Summary(parcel)
        }

        override fun newArray(size: Int): Array<Summary?> {
            return arrayOfNulls(size)
        }
    }

}