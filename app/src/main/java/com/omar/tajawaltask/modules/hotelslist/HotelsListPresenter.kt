package com.omar.tajawaltask.modules.hotelslist

import com.omar.tajawaltask.app.data.Hotel
import com.omar.tajawaltask.app.data.remote.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
class HotelsListPresenter(val mView: HotelListContract.View) : HotelListContract.Presenter {

    override fun start() {
        mView.init()
    }

    override fun loadHotels() {
        mView.showProgress()

        ApiService.create().getHotels()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    mView.hideProgress()
                    mView.setHotels(result.hotel)
                }, { error ->
                    mView.hideProgress()
                    mView.showError(error.localizedMessage)
                })

    }

    override fun refresh() {
        mView.refresh()
        loadHotels()
    }

    override fun onItemClicked(hotel: Hotel) {
        mView.navigateToHotel(hotel)
    }

}