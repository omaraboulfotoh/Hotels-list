package com.omar.tajawaltask.modules.hotelslist

import com.omar.tajawaltask.app.data.Hotel

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
interface HotelListContract {
    interface View {
        fun init()
        fun setHotels(arrayList: ArrayList<Hotel>)
        fun refresh()
        fun navigateToHotel(hotel: Hotel)
        fun showError(message: String)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter {
        fun start()
        fun loadHotels()
        fun onItemClicked(hotel: Hotel)
        fun refresh()
    }
}