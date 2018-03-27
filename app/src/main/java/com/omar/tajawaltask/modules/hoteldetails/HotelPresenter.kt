package com.omar.tajawaltask.modules.hoteldetails

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
class HotelPresenter(val mView: HotelContract.View) : HotelContract.Presenter {


    override fun init() {
        val hotel = mView.getHotel()
        mView.displayHotel(hotel.images[0].url, hotel.summary.name, hotel.location.address
                , hotel.summary.lowRate, hotel.summary.highRate, hotel.location.lat, hotel.location.lng)
    }

}