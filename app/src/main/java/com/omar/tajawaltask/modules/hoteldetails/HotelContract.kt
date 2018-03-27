package com.omar.tajawaltask.modules.hoteldetails

import com.omar.tajawaltask.app.data.Hotel

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
interface HotelContract {
    interface View {
        fun displayHotel(img: String, title: String, address: String, lowPrice: Double, highPrice: Double, lat: Double, lng: Double)
        fun getHotel(): Hotel
    }

    interface Presenter {
        fun init()
    }
}